package org.dominokit.domino.binding.client.internal.helper;

import elemental2.dom.EventListener;
import org.dominokit.domino.ui.forms.BasicFormElement;

public class MessageElementWrapper {

  private BasicFormElement<?, ?> formElement;
  private String                 fieldId;
  private EventListener          blurEventListener;
  //  private List<InvalidHandler>   invalidHandlers;
  //  private List<ValidHandler>     validHandlers;

  public MessageElementWrapper() {
    this(null,
         null);
  }

  public MessageElementWrapper(BasicFormElement<?, ?> formElement,
                               String fieldId) {
    this.formElement = formElement;
    this.fieldId = fieldId;
  }

  /**
   * Adds a InvalidHandler to all added widgets.
   * <p>
   * The handler will be executed in case the error is markes as
   * invalid.
   *
   * @param handler the handler
   * @return handler registration
   */
  //  public HandlerRegistration addInvalidHandler(InvalidHandler handler) {
  //    this.invalidHandlers.add(handler);
  //    return () -> {
  //      this.invalidHandlers.remove(handler);
  //    };
  //  }
  public EventListener getBlurEventListener() {
    return blurEventListener;
  }

  public void setBlurEventListener(EventListener blurEventListener) {
    this.blurEventListener = blurEventListener;
  }

  /**
   * Adds a BlurHandler to all added widgets
   * <p>
   * The handler will be executed in case the widget blurs
   *
   * @param handler the handler
   * @return handler registration
   */
  //  public HandlerRegistration addBlurHandler(BlurHandler handler) {
  //    this.blurHandlers.add(handler);
  //    return () -> {
  //      this.blurHandlers.remove(handler);
  //    };
  //  }

  /**
   * Adds a ValidHandler to all added widgets
   * <p>
   * The handler will be execute in case the in element gets marked as valid.
   *
   * @param handler the handler
   * @return handler registration
   */
  //  public HandlerRegistration addValidHandler(ValidHandler handler) {
  //    this.validHandlers.add(handler);
  //    return () -> {
  //      this.validHandlers.remove(handler);
  //    };
  //  }

  /**
   * Return the  element
   *
   * @return element
   */
  public BasicFormElement<?, ?> getFormElement() {
    return this.formElement;
  }

  /**
   * Return the field-id registered for this element
   *
   * @return field id for this element
   */
  public String getFieldId() {
    return this.fieldId;
  }

  /**
   * Marks a element as in error with the given error message
   *
   * @param message error messaghe
   */
  public void invalidate(String message) {
    this.formElement.invalidate(message);
    //    this.invalidHandlers.forEach(h -> h.onInvalid(this.formElement));
  }

  /**
   * removes the error message
   */
  public void clearInvalid() {
    this.formElement.clearInvalid();
  }

}
