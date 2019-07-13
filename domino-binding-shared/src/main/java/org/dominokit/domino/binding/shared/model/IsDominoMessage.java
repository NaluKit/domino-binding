package org.dominokit.domino.binding.shared.model;

import java.util.List;

public interface IsDominoMessage {

  String getId();

  void setId(String id);

  String getMessageId();

  void setMessageId(String messageId);

  String getText();

  void setText(String text);

  Target getTarget();

  void setTarget(Target target);

  List<String> getErrorSources();

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
