package org.dominokit.domino.binding.client.handling.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks a visual component and tells the processor
 * IsNaluMessageDriver
 * Diese Annotation kennzeichnet ein Widget in einen View als konfigurierbar,
 * d.h.: in diesem View befinden sich Widgets, die von aussen konfiguriert
 * werden koennen. Ein mit dieser Annotation gekennzeichneter View muss das
 * Interface {@link org.dominokit.domino.binding.client.handling.IsMessageDriver} implementieren.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HasMessageDriverSupport {

  /**
   * Defines, how widgets will handle error messages
   * <ul>
   * <li><b>false</b>: error message will be removed the next time error messages will be set</li>
   * <li><b>true</b>: error message will be removed in case a field blurs</li>
   * </ul>
   * <p/>
   * Default is <b>true</b>
   *
   * @return how to handle a error message on a widget
   */
  boolean clearOnBlur() default true;

}
