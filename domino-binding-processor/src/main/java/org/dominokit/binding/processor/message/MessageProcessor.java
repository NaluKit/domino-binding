/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package org.dominokit.binding.processor.message;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.*;
import org.dominokit.binding.processor.ProcessorException;
import org.dominokit.binding.processor.ProcessorUtils;
import org.dominokit.domino.binding.message.client.handling.AbstractMessageDriver;
import org.dominokit.domino.binding.message.client.handling.IsMessageDriver;
import org.dominokit.domino.binding.message.client.handling.annotation.HasMessageDriverSupport;
import org.dominokit.domino.binding.message.client.handling.annotation.MessagePresenter;
import org.dominokit.domino.binding.message.client.internal.helper.MessageElementWrapper;
import org.dominokit.domino.ui.forms.BasicFormElement;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

@AutoService(Processor.class)
public class MessageProcessor
    extends AbstractProcessor {

  private final static String IMPL_NAME = "MessageDriverImpl";

  private ProcessorUtils processorUtils;

  private Map<Element, List<VariableElement>> messagePresenterAnnotatedElements;

  public MessageProcessor() {
    super();
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.RELEASE_8;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    return of(HasMessageDriverSupport.class.getCanonicalName()).collect(toSet());
  }

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    this.setUp();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations,
                         RoundEnvironment roundEnv) {
    try {
      if (!roundEnv.processingOver()) {
        if (annotations.size() > 0) {
          for (TypeElement annotation : annotations) {
            if (HasMessageDriverSupport.class.getCanonicalName()
                                             .equals(annotation.toString())) {
              handleHasNaluMessagePresenterSupportAnnotation(roundEnv);
              for (Element k : this.messagePresenterAnnotatedElements.keySet()) {
                this.generateDriver(k,
                                    this.messagePresenterAnnotatedElements.get(k));
              }
            }
          }
        }
      }
    } catch (ProcessorException e) {
      this.processorUtils.createErrorMessage(e.getMessage());
      return true;
    }
    return true;
  }

  private void generateDriver(Element annotatedElement,
                              List<VariableElement> variableElements)
      throws ProcessorException {
    TypeSpec.Builder typeSpec = TypeSpec.classBuilder(annotatedElement.getSimpleName() + MessageProcessor.IMPL_NAME)
                                        .superclass(ParameterizedTypeName.get(ClassName.get(AbstractMessageDriver.class),
                                                                              ClassName.get((TypeElement) annotatedElement)))
                                        .addModifiers(Modifier.PUBLIC,
                                                      Modifier.FINAL)
                                        .addSuperinterface(ParameterizedTypeName.get(ClassName.get(IsMessageDriver.class),
                                                                                     ClassName.get((TypeElement) annotatedElement)));

    MethodSpec constructor = MethodSpec.constructorBuilder()
                                       .addModifiers(Modifier.PUBLIC)
                                       .addStatement("super()")
                                       .build();
    typeSpec.addMethod(constructor);

    List<String> usedFieldIds = new ArrayList<>();
    MethodSpec.Builder initializeMethod = MethodSpec.methodBuilder("initialize")
                                                    .addAnnotation(ClassName.get(Override.class))
                                                    .addModifiers(Modifier.PUBLIC)
                                                    .addParameter(ClassName.get((TypeElement) annotatedElement),
                                                                  "provider");
    HasMessageDriverSupport hasMessageDriverSupportAnnotation = annotatedElement.getAnnotation(HasMessageDriverSupport.class);
    initializeMethod.addStatement("super.clearOnBlur = $L",
                                  hasMessageDriverSupportAnnotation.clearOnBlur());
    for (VariableElement variableElement : variableElements) {
      String messagePresenterId = variableElement.getAnnotation(MessagePresenter.class)
                                                 .value();
      if (usedFieldIds.contains(messagePresenterId)) {
        throw new ProcessorException("Nalu-Message-Processor: MessagePresenter-ID >>" + messagePresenterId + "<< is not unique!");
      }
      usedFieldIds.add(messagePresenterId);
      initializeMethod.addStatement("super.messageElementWrappers.put($S, new $T(provider.$L, $S))",
                                    messagePresenterId,
                                    ClassName.get(MessageElementWrapper.class),
                                    variableElement.getSimpleName(),
                                    variableElement.getAnnotation(MessagePresenter.class)
                                                   .value());
    }
    typeSpec.addMethod(initializeMethod.build());

    JavaFile javaFile = JavaFile.builder(this.getPackageAsString(annotatedElement),
                                         typeSpec.build())
                                .build();
    try {
//      System.out.println(javaFile.toString());
      javaFile.writeTo(this.processingEnv.getFiler());
    } catch (IOException e) {
      throw new ProcessorException("Nalu-Message-Processor: Unable to write generated file: >>" + annotatedElement.getSimpleName() + MessageProcessor.IMPL_NAME + "<< -> exception: " + e.getMessage());
    }
  }

  private void handleHasNaluMessagePresenterSupportAnnotation(RoundEnvironment roundEnv)
      throws ProcessorException {
    for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(HasMessageDriverSupport.class)) {
      this.validateTypeElement(annotatedElement);
      this.messagePresenterAnnotatedElements.put(annotatedElement,
                                                 new ArrayList<>());
      List<Element> annotatedFields = this.getElemntsFromTypeElementAnnotatedWith((TypeElement) annotatedElement);
      for (Element e : annotatedFields) {
        validateVariableElement(e);
        this.messagePresenterAnnotatedElements.get(annotatedElement)
                                              .add((VariableElement) e);
      }
    }
  }

  private void setUp() {
    this.processorUtils = ProcessorUtils.builder()
                                        .processingEnvironment(processingEnv)
                                        .build();
    this.messagePresenterAnnotatedElements = new HashMap<>();
  }

  private void validateTypeElement(Element annotatedElement)
      throws ProcessorException {
    if (annotatedElement instanceof TypeElement) {
      TypeElement typeElement = (TypeElement) annotatedElement;
      if (!typeElement.getKind()
                      .isClass()) {
        throw new ProcessorException("Nalu-Message-Processor: @HasNaluMessageDriverSupport must be used with a class");
      }
    } else {
      throw new ProcessorException("Nalu-Message-Processor:" + "@HasNaluMessageDriverSupport can only be used on a type (class)");
    }
  }

  private void validateVariableElement(Element annotatedElement)
      throws ProcessorException {
    if (annotatedElement instanceof VariableElement) {
      VariableElement variableElement = (VariableElement) annotatedElement;
      if (!variableElement.getKind()
                          .isField()) {
        throw new ProcessorException("Nalu-Message-Processor: @MessagePresenter must be used with a field");
      }
      if (!this.processorUtils.extendsClassOrInterface(super.processingEnv.getTypeUtils(),
                                                       variableElement.asType(),
                                                       this.processingEnv.getElementUtils()
                                                                         .getTypeElement(BasicFormElement.class.getCanonicalName())
                                                                         .asType())) {
        throw new ProcessorException("Nalu-Message-Processor: " +
                                     variableElement.getSimpleName()
                                                    .toString() +
                                     ": @MessageSupport: element must extend BasicFormElement (Domino-UI) super class");
      }
    } else {
      throw new ProcessorException("Nalu-Message-Processory:" + "@Nalu-MessageSupport can only be used on a type (field)");
    }
  }

  private String getPackageAsString(Element type) {
    return this.getPackage(type)
               .getQualifiedName()
               .toString();
  }

  private PackageElement getPackage(Element type) {
    while (type.getKind() != ElementKind.PACKAGE) {
      type = type.getEnclosingElement();
    }
    return (PackageElement) type;
  }

  private <A extends Annotation> List<Element> getElemntsFromTypeElementAnnotatedWith(TypeElement element) {
    return this.processingEnv.getElementUtils()
                             .getAllMembers(element)
                             .stream()
                             .filter(methodElement -> methodElement.getAnnotation(MessagePresenter.class) != null)
                             .collect(Collectors.toList());
  }

}
