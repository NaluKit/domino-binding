package org.dominokit.domino.binding.client.handling;

import com.google.gwt.core.client.GWT;
import org.dominokit.domino.binding.client.internal.helper.MessageElementWrapper;
import org.dominokit.domino.binding.shared.model.IsDominoMessage;
import org.jboss.gwt.elemento.core.EventType;

import java.util.*;

/**
 * Abstract class of the message driver
 * <p/>
 * Contains the base implementation of the driver
 *
 * @param <P> name of the MessageProvider
 */
public abstract class AbstractMessageDriver<P extends IsMessageProvider>
    implements IsMessageDriver<P> {

  protected boolean clearOnBlur;

  protected Map<String, MessageElementWrapper> messageElementWrappers;

  public AbstractMessageDriver() {
    this.messageElementWrappers = new HashMap<>();
    this.clearOnBlur = true;
  }

  @Override
  public void deregister() {
    this.messageElementWrappers.values()
                               .forEach(e -> {
                                 e.getFormElement()
                                  .getInputElement()
                                  .removeEventListener(EventType.blur,
                                                       e.getBlurEventListener());
                                 e.setBlurEventListener(null);
                               });
  }

  @Override
  public void clearInvalid() {
    this.messageElementWrappers.values()
                               .forEach(w -> w.getFormElement()
                                              .clearInvalid());
  }

  @Override
  public void consume(List<? extends IsDominoMessage> messages) {
    List<IsDominoMessage> unconsumedMessages = new ArrayList<>();
    messages.forEach(m -> {
      GWT.log(IsDominoMessage.Target.FIELD.toString());
      GWT.log(m.getTarget()
               .toString());
      if (IsDominoMessage.Target.FIELD.toString()
                                      .equals(m.getTarget()
                                               .toString())) {
        m.getErrorSources()
         .stream()
         .map(errorSource -> this.messageElementWrappers.get(errorSource))
         .forEach(wrapper -> {
           if (Objects.isNull(wrapper)) {
             unconsumedMessages.add(m);
           }
           wrapper.getFormElement()
                  .invalidate(m.getText());
         });
      } else {
        unconsumedMessages.add(m);
      }

    });
    //    // TODO handle unconsumed messages
  }

  @Override
  public void deregisterAndDestroy() {
    this.deregister();
    this.destroy();
  }

  @Override
  public void destroy() {
    this.messageElementWrappers.clear();
  }

  @Override
  public void register() {
    this.messageElementWrappers.values()
                               .forEach(w -> {
                                 if (clearOnBlur) {
                                   elemental2.dom.EventListener eventlistener = evt -> {
                                     w.getFormElement()
                                      .clearInvalid();
                                   };
                                   w.getFormElement()
                                    .getInputElement()
                                    .addEventListener(EventType.blur,
                                                      eventlistener);
                                   w.setBlurEventListener(eventlistener);
                                 }
                               });
  }

}
