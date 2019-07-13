package org.dominokit.domino.binding.shared.model;

import java.util.List;

public interface IsDominoMessage {

  /**
   * Unique ID
   *
   * @return the unique object id
   */
  String getId();

  /**
   * Sets the unique id
   *
   * @param id sets the unique id
   */
  void setId(String id);

  /**
   * The Id of the message
   *
   * @return returns the message id
   */
  String getMessageId();

  /**
   * sets the message id
   *
   * @param messageId the ID of the message
   */
  void setMessageId(String messageId);

  /**
   * The error message
   *
   * @return the error message
   */
  String getText();

  /**
   * sets the error message
   *
   * @param text the error message
   */
  void setText(String text);

  /**
   * The target of the error message.
   *
   * @return the error message
   */
  Target getTarget();

  /**
   * set the target
   *
   * @param target the target
   */
  void setTarget(Target target);

  /**
   * Defines the error source by using the name from the MessagePresenter annotation.
   * <p/>
   * It is possible to set more than one error source for a message. In this case
   * the message wil be displayed on every referenced MessagePresenter
   *
   * @return list of error sources
   */
  List<String> getErrorSources();

  /**
   * returns a list of the referenced MessagePresenters
   *
   * @param errorSources list of message presenters
   */
  void setErrorSources(List<String> errorSources);

  /**
   * The Target defines the place where the message will be shown.
   *
   * <b>DIALOG</b>
   * The message will be shown once in a pop-up.
   * <b>FACTORY</b>
   * The message will be added to the messages of the message factory. It will be
   * shown, as long as the MessageFactory gets not cleared.
   * <b>FIELD</b>
   * The message will be added to the fields that are referenced.
   * It will be delete, once one of the referenced fields gets blurred ..
   */
  public enum Target {
    DIALOG,
    FACTORY,
    FIELD;
  }

}
