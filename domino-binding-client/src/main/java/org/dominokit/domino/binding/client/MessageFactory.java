package org.dominokit.domino.binding.client;

import org.dominokit.domino.binding.client.presenter.IsProgressBarPresenter;
import org.dominokit.domino.binding.client.presenter.PresenterRegistration;

import java.util.Objects;

/**
 * <p>MessageFactory</p>
 * <p>
 * Verwaltet die Meldungen einer Anwendung.
 * </p>
 */
public class MessageFactory {

  //  private final static boolean WRITE_LOG = true;

  /* instance of the MessageFactory */
  private static MessageFactory instance;

  //  //  /* Liste der MessagePresenter (PERMANENT) (normalerweise ein Widget mit einer List-Anzeige */
  //  //  private List<MessagePresenter> permanentMessagePresenterList;
  //  //
  //  //  /* MessagePresenter fuer Messages mit Visibilty.ONCE (normalerweise ein Window) */
  //  //  private WindowMessagePresenter onceMessagePresenter;
  //  //
  //  //  private PresenterRegistration onceMessagePresenterRegistration;
  //  //
  //  //  /* ConfirmCancelMessagePresenter  */
  //  //  private ConfirmCancelMessagePresenter confirmCancelMessagePresenter;
  //  //
  //  //  private PresenterRegistration confirmCancelMessagePresenterRegistration;
  //  //
  //  //  /* ConfirmMessagePresenter  */
  //  //  private ConfirmCustomMessagePresenter confirmMessagePresenter;
  //  //
  //  //  private PresenterRegistration confirmMessagePresenterRegistration;

  /* ProgressBar  */
  private IsProgressBarPresenter progressBarPresenter;
  private PresenterRegistration  progressBarPresenterRegistration;
  private boolean                progressBarActive;

  //  //  /* ProgressBar  */
  //  //  private TechnicalErrorMessagePresenter technicalErrorMessagePresenter;
  //  //
  //  //  private PresenterRegistration technicalErrorMessagePresenterRegistration;
  //  //
  //  //  /* Liste  der Widgets, die Fehlermeldungen am Widget ausgeben koennen. (Gemein hin Eingabe-Fehler) */
  //  //  private Map<String, List<MessagePresenterWidget>> presenterWidgets;
  //
  //  /* Liste der Meldungen */
  //  private List<ClMessage> messageList;
  //
  //  //  /* Liste der Meldungen, die im LiveCycle nur EINMAL angezeigt werden dürfen, auch nach mehrmaligem Einstellen */
  //  //  private List<GsMessage> messageListSingular;
  //  //
  //  //  /* MessageAccumulator */
  //  //  private MessageAccumulator messageAccumulator;
  //  //
  //  //  private boolean masterlock;

  private MessageFactory() {
    super();
    //    this.messageList = new ArrayList<>();
    //    //    this.messageListSingular = new ArrayList<>();
    //    //    this.presenterWidgets = new HashMap<>();
    //    //    this.permanentMessagePresenterList = new ArrayList<>();
  }

  /**
   * returns the instance of the MessageFactory
   *
   * @return instance of the MessageFactory (Singleton)
   */
  public static MessageFactory get() {
    if (instance == null) {
      instance = new MessageFactory();
    }
    return instance;
  }

  //  //  /**
  //  //   * <p>Registriert einen MessagePresenter fuer die Anzeige permernenter Meldungen.</p>
  //  //   * <p>REs koennen beliebig viele MessagePresenter registirert werden.</p>
  //  //   *
  //  //   * @param messagePresenter zu registrierender MessagePresenter
  //  //   * @return MessagePresenterRegistrierung
  //  //   */
  //  //  public PresenterRegistration register(final MessagePresenter messagePresenter) {
  //  //    this.permanentMessagePresenterList.add(messagePresenter);
  //  //    return new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        permanentMessagePresenterList.remove(messagePresenter);
  //  //      }
  //  //    };
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Registriert einen MessagePresenter fuer die Anzeige von Meldungen
  //  //   * des Types ONCE. Normalerweise handelt es sich dabei um ein Window. Abh.
  //  //   * vom Typ der Messages wird ein entsprechendes Icon ausgegeben.</p>
  //  //   *
  //  //   * @param messagePresenter zu registrierender MessagePresenter
  //  //   * @return MessagePresenterRegistrierung
  //  //   */
  //  //  public PresenterRegistration register(final WindowMessagePresenter messagePresenter) {
  //  //    if (this.onceMessagePresenterRegistration != null) {
  //  //      this.onceMessagePresenterRegistration.remove();
  //  //    }
  //  //    this.onceMessagePresenter = messagePresenter;
  //  //    this.onceMessagePresenterRegistration = new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        onceMessagePresenter = null;
  //  //      }
  //  //    };
  //  //    return onceMessagePresenterRegistration;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Registriert einen MessageAccumulator an der MessageFactory fuer
  //  //   * das anreichern von Meldungen.</p>
  //  //   *
  //  //   * @param messageAccumulator zu registrierender MessageAccumulator
  //  //   * @return MessagePresenterRegistrierung
  //  //   */
  //  //  public void register(MessageAccumulator messageAccumulator) {
  //  //    this.messageAccumulator = messageAccumulator;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Registriert einen ConfirmCancelMessagePresenter.</p>
  //  //   *
  //  //   * @param confirmCancelPresenter zu registrierender confirmCancelMessagePresenter
  //  //   * @return MessagePresenterRegistrierung
  //  //   */
  //  //  public PresenterRegistration register(final ConfirmCancelMessagePresenter confirmCancelPresenter) {
  //  //    if (this.confirmCancelMessagePresenterRegistration != null) {
  //  //      this.confirmCancelMessagePresenterRegistration.remove();
  //  //    }
  //  //    this.confirmCancelMessagePresenter = confirmCancelPresenter;
  //  //    this.confirmCancelMessagePresenterRegistration = new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        confirmCancelMessagePresenter = null;
  //  //      }
  //  //    };
  //  //    return confirmCancelMessagePresenterRegistration;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Registriert einen ConfirmMessagePresenter.</p>
  //  //   *
  //  //   * @param confirmPresenter zu registrierender confirmMessagePresenter
  //  //   * @return MessagePresenterRegistrierung
  //  //   */
  //  //  public PresenterRegistration register(final ConfirmCustomMessagePresenter confirmPresenter) {
  //  //    if (this.confirmMessagePresenterRegistration != null) {
  //  //      this.confirmMessagePresenterRegistration.remove();
  //  //    }
  //  //    this.confirmMessagePresenter = confirmPresenter;
  //  //    this.confirmMessagePresenterRegistration = new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        confirmMessagePresenter = null;
  //  //      }
  //  //    };
  //  //    return confirmMessagePresenterRegistration;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Registriert eine TechnicalErrorMessagePresenter.</p>
  //  //   *
  //  //   * @param technicalErrorMessagePresenter zu registrierender TechnicalErrorMessagePresenter
  //  //   * @return TechnicalErrorMessagePresenterRegistrierung
  //  //   */
  //  //  public PresenterRegistration register(TechnicalErrorMessagePresenter technicalErrorMessagePresenter) {
  //  //    if (this.technicalErrorMessagePresenter != null) {
  //  //      this.technicalErrorMessagePresenterRegistration.remove();
  //  //    }
  //  //    this.technicalErrorMessagePresenter = technicalErrorMessagePresenter;
  //  //    this.technicalErrorMessagePresenterRegistration = new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        MessageFactory.this.technicalErrorMessagePresenter = null;
  //  //      }
  //  //    };
  //  //    return technicalErrorMessagePresenterRegistration;
  //  //  }

  /**
   * Register a progressbar
   *
   * @param progressBarPresenter the progress bar
   * @return the registration of the progress bar
   */
  public PresenterRegistration register(IsProgressBarPresenter progressBarPresenter) {
    if (this.progressBarPresenterRegistration != null) {
      this.progressBarPresenterRegistration.remove();
    }
    this.progressBarPresenter = progressBarPresenter;
    this.progressBarPresenterRegistration = new PresenterRegistration() {
      @Override
      public void remove() {
        MessageFactory.this.progressBarPresenter = null;
      }
    };
    return progressBarPresenterRegistration;
  }

  //  //  /**
  //  //   * <p>Registriert ein Widget mit {@link HasGsMessagePresenterSupport}
  //  //   * an der MessageFactory.</p>
  //  //   *
  //  //   * @param messageWidgetId ID des Feldes
  //  //   * @param widget          Widget zru Anzeige eines Fehlers
  //  //   * @return {@link PresenterRegistration}
  //  //   */
  //  //  public PresenterRegistration register(String messageWidgetId,
  //  //                                        HasGsMessagePresenterSupport widget) {
  //  //    this.log("Methode: register -> fieldid >>" +
  //  //                 messageWidgetId +
  //  //                 "<< - widget >>" +
  //  //                 widget.getClass()
  //  //                       .getCanonicalName() +
  //  //                 "<<");
  //  //    List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(messageWidgetId);
  //  //    if (messagePresenterWidgets == null) {
  //  //      messagePresenterWidgets = new ArrayList<>();
  //  //    }
  //  //    final MessagePresenterWidget mpw = new MessagePresenterWidget(messageWidgetId,
  //  //                                                                  widget);
  //  //    messagePresenterWidgets.add(mpw);
  //  //    presenterWidgets.put(messageWidgetId,
  //  //                         messagePresenterWidgets);
  //  //    final List<MessagePresenterWidget> finalMessagePresenterWidgets = messagePresenterWidgets;
  //  //    return new PresenterRegistration() {
  //  //      @Override
  //  //      public void remove() {
  //  //        finalMessagePresenterWidgets.remove(mpw);
  //  //        presenterWidgets.remove(mpw);
  //  //      }
  //  //    };
  //  //  }
  //  //
  //  //  private void log(String message) {
  //  //    if (MessageFactory.WRITE_LOG) {
  //  //      NativeUtils.logToConsole("MessageFactory (at " +
  //  //                                   DateTimeFormat.getFormat("yyyy.MM.dd-HH:mm.ss")
  //  //                                                 .format(new Date()) +
  //  //                                   "): " +
  //  //                                   message);
  //  //    }
  //  //  }
  //  //
  //  //  public void lookUpForExistingMessages() {
  //  //    for (GsMessage message : this.messageList) {
  //  //      if (Type.ERROR.equals(message.getType())) {
  //  //        if (Visibility.PERMANENT.equals(message.getVisibility())) {
  //  //          lookUpForExistingMessagePresenter(message);
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  private void lookUpForExistingMessagePresenter(GsMessage message) {
  //  //    if (message.getText() == null) {
  //  //      assert false : "Kein Meldungstext vorhanden";
  //  //      return;
  //  //    }
  //  //    if (message.getFieldInError() != null) {
  //  //      for (String messageWidgetId : message.getFieldInError()) {
  //  //        List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(messageWidgetId);
  //  //        if (messagePresenterWidgets != null) {
  //  //          for (MessagePresenterWidget mpw : messagePresenterWidgets) {
  //  //            if (messageWidgetId.equals(mpw.getFieldInError())) {
  //  //              mpw.getWidget()
  //  //                 .forceInvalid(message.getText());
  //  //            }
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //    // Und jetzt schauen wir noch in die MessagePresenterWithoutBlurHandling
  //  //    if (message.getMessageWidgetsWithoutBlurHandling() != null) {
  //  //      for (String messageWidgetId : message.getMessageWidgetsWithoutBlurHandling()) {
  //  //        List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(messageWidgetId);
  //  //        if (messagePresenterWidgets != null) {
  //  //          for (MessagePresenterWidget mpw : messagePresenterWidgets) {
  //  //            if (messageWidgetId.equals(mpw.getFieldInError())) {
  //  //              mpw.getWidget()
  //  //                 .forceInvalid(message.getText());
  //  //            }
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt alle Meldungen mit der übergebenen groupId</p>
  //  //   *
  //  //   * @param key01 erster Schluessel
  //  //   */
  //  //  public void removeMessagesForKey01(String key01) {
  //  //    if (key01 != null) {
  //  //      for (int i = this.messageList.size() - 1; i > -1; i--) {
  //  //        GsMessage message = this.messageList.get(i);
  //  //        if (key01.equals(message.getKey01())) {
  //  //          remove(message);
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt die übergebene Meldung aus der Liste der permanten Meldungen.</p>
  //  //   *
  //  //   * @param message zu loeschende Meldung
  //  //   */
  //  //  public void remove(GsMessage message) {
  //  //    String logMessage = "MessageFactory: remove Message for key01: >>" +
  //  //        message.getKey01() +
  //  //        "<< and key02 >>" +
  //  //        message.getKey02() +
  //  //        "<< with MessageId >>" +
  //  //        message.getMessageId() +
  //  //        "<< and MessageWidgetIds: >>";
  //  //    for (String fieldId : message.getFieldInError()) {
  //  //      logMessage += fieldId + ", ";
  //  //    }
  //  //    if (logMessage.endsWith(", ")) {
  //  //      logMessage = logMessage.substring(0,
  //  //                                        logMessage.length() - 2);
  //  //    }
  //  //    assert permanentMessagePresenterList.size() != 0 : "MessageFactory: no permanentMessagePresenter defined!";
  //  //    List<String> widgetsToClear = new ArrayList<>();
  //  //    messageList.remove(message);
  //  //    for (MessagePresenter messagePresenter : permanentMessagePresenterList) {
  //  //      for (String widgetId : message.getFieldInError()) {
  //  //        widgetsToClear.add(widgetId);
  //  //      }
  //  //      messagePresenter.remove(message);
  //  //    }
  //  //    // auf die Felder der Message ein ClearInvalid absetzen ...
  //  //    for (String widgetId : widgetsToClear) {
  //  //      List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(widgetId);
  //  //      if (messagePresenterWidgets != null) {
  //  //        for (MessagePresenterWidget mpw : messagePresenterWidgets) {
  //  //          mpw.getWidget()
  //  //             .clearInvalid();
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt alle Meldungen mit der messageId</p>
  //  //   *
  //  //   * @param pMessageId erster Schluessel
  //  //   */
  //  //  public void removeMessagesForId(String pMessageId) {
  //  //    if (pMessageId != null) {
  //  //      for (int i = this.messageList.size() - 1; i > -1; i--) {
  //  //        GsMessage message = this.messageList.get(i);
  //  //        if (pMessageId.equals(message.getMessageId())) {
  //  //          remove(message);
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt alle Meldungen mit der übergebenen groupId</p>
  //  //   *
  //  //   * @param key01  Context der zu entfernenden Meldungen
  //  //   * @param key02s Liste an Keys der zu loeschenden Meldungen
  //  //   */
  //  //  public void removeMessagesForKey01AndKey02(String key01,
  //  //                                             String... key02s) {
  //  //    if (key01 != null) {
  //  //      for (String key02 : key02s) {
  //  //        for (int i = this.messageList.size() - 1; i > -1; i--) {
  //  //          GsMessage message = this.messageList.get(i);
  //  //          if (key01.equals(message.getKey01())) {
  //  //            if (key02 == null) {
  //  //              remove(message);
  //  //            } else if (key02.equals(message.getKey02())) {
  //  //              remove(message);
  //  //            }
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt alle Meldungen mit der übergebenen groupId</p>
  //  //   *
  //  //   * @param key02 Context der zu entfernenden Meldungen
  //  //   */
  //  //  public void removeMessagesForKey02(String key02) {
  //  //    if (key02 != null) {
  //  //      for (int i = this.messageList.size() - 1; i > -1; i--) {
  //  //        GsMessage message = this.messageList.get(i);
  //  //        if (key02.equals(message.getKey02())) {
  //  //          remove(message);
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //
  //  /**
  //   * Adds a list of messages to the message factory
  //   *
  //   * @param messages list of new messages
  //   */
  ////  public void addAll(List<ClMessage> messages) {
  ////    messages.forEach(this::add);
  ////  }
  //
  //  /**
  //   * adds a message to the message factory
  //   *
  //   * @param message message
  //   */
  ////  public void add(ClMessage message) {
  ////    add(message,
  ////        true);
  ////  }
  ////
  ////  //  public void setupNote(boolean hasNote) {
  ////  //    for (MessagePresenter messagePresenter : permanentMessagePresenterList) {
  ////  //      messagePresenter.setupNote(hasNote);
  ////  //    }
  ////  //  }
  ////
  ////  /**
  ////   * adds a message to the message list
  ////   *
  ////   * @param message           new message
  ////   * @param showMessageWindow true ->  show the message window
  ////   */
  ////  public void add(ClMessage message,
  ////                  boolean showMessageWindow) {
  ////    // Logmessage für die Konsole vorbereiten und ausgeben
  ////    final String[] logMessage = { "MessageFactory: add Message for key01: >>" + message.getKey01() + "<< and key02 >>" + message.getKey02() + "<< with MessageId >>" + message.getMessageId() + "<< and MessageWidgetIds: >>" };
  ////    message.getFieldInError()
  ////           .forEach(s -> logMessage[0] += s + ", ");
  ////    if (logMessage[0].endsWith(", ")) {
  ////      logMessage[0] = logMessage[0].substring(0,
  ////                                              logMessage[0].length() - 2);
  ////    }
  ////    logMessage[0] += "<<";
  ////    if ("on".equals(System.getProperty("superdevmode",
  ////                                       "off"))) {
  ////      DomGlobal.window.console.log(logMessage[0]);
  ////    }
  ////    //    // Permanente Meldungen kommen in die MessageList
  ////    //    if (Visibility.PERMANENT.equals(message.getVisibility()) || Visibility.PERMANENT_SINGULAR.equals(message.getVisibility())) {
  ////    //      if (!checkIfMessaegeAlreadyAdded(message) && !checkIfMessaegeAlreadyAddedSingular(message)) {
  ////    //        messageList.add(messageAccumulator.accumulate(message));
  ////    //        assert permanentMessagePresenterList.size() != 0 : "MessageFactory: no permanentMessagePresenter defined!";
  ////    //        for (MessagePresenter messagePresenter : permanentMessagePresenterList) {
  ////    //          messagePresenter.add(message,
  ////    //                               showMessageWindow);
  ////    //        }
  ////    //      }
  ////    //      // Ans Widget haengen ...
  ////    //      this.lookUpForExistingMessagePresenter(message);
  ////    //    }
  ////    //
  ////    //    // Einmalmeldungen per Presenter anzeigen
  ////    //    if (Visibility.ONCE.equals(message.getVisibility()) || Visibility.ONCE_SINGULAR.equals(message.getVisibility())) {
  ////    //      assert onceMessagePresenter != null : "MessageFactory: no permanentMessagePresenter defined!";
  ////    //      showMessage(getTypeFromMessage(message.getType()),
  ////    //                  null,
  ////    //                  Collections.singletonList(message.getText()),
  ////    //                  true,
  ////    //                  null);
  ////    //    }
  ////    //
  ////    //    // und noch hinterlegen, dass die meldung ggf. nicht noch einmal angezeigt wird.
  ////    //    if (Visibility.PERMANENT_SINGULAR.equals(message.getVisibility()) || Visibility.ONCE_SINGULAR.equals(message.getVisibility())) {
  ////    //      if (!checkIfMessaegeAlreadyAddedSingular(message)) {
  ////    //        messageListSingular.add(messageAccumulator.accumulate(message));
  ////    //      }
  ////    //    }
  ////  }
  //
  //  //  /**
  //  //   * <p>Methode prueft, ob eine Meldung mit dieser ID schon in der Liste
  //  //   * der permanenten Meldungen vorhandnen ist.
  //  //   * </p>
  //  //   * <p>
  //  //   * Wenn die Message gefunden wird, muss in einem weiteren Schritt
  //  //   * geprueft werden, ob die MessageWidgetIdentifier enthalten sind.
  //  //   * wenn nicht, muessen diese hinzugefuegt werden!
  //  //   * </p>
  //  //   */
  //  //  private boolean checkIfMessaegeAlreadyAdded(GsMessage message) {
  //  //    for (GsMessage value : messageList) {
  //  //      if (value.equals(message)) {
  //  //        for (String fieldId : message.getFieldInError()) {
  //  //          if (!value.getFieldInError()
  //  //                    .contains(fieldId)) {
  //  //            value.getFieldInError()
  //  //                 .add(fieldId);
  //  //          }
  //  //        }
  //  //        return true;
  //  //      }
  //  //    }
  //  //    return false;
  //  //  }
  //  //
  //  //  private boolean checkIfMessaegeAlreadyAddedSingular(GsMessage message) {
  //  //    for (GsMessage value : messageListSingular) {
  //  //      if (value.equals(message)) {
  //  //        for (String fieldId : message.getFieldInError()) {
  //  //          if (!value.getFieldInError()
  //  //                    .contains(fieldId)) {
  //  //            value.getFieldInError()
  //  //                 .add(fieldId);
  //  //          }
  //  //        }
  //  //        return true;
  //  //      }
  //  //    }
  //  //    return false;
  //  //  }
  //  //
  //  //  private void showMessage(WindowMessagePresenter.Type type,
  //  //                           String heading,
  //  //                           List<String> messages,
  //  //                           boolean showIntro,
  //  //                           WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    assert onceMessagePresenter != null : "MessageFactory: no WindowMessagePresenter defined!";
  //  //    onceMessagePresenter.setUp(type,
  //  //                               heading,
  //  //                               messages,
  //  //                               showIntro,
  //  //                               closeHandler);
  //  //  }
  //  //
  //  //  private WindowMessagePresenter.Type getTypeFromMessage(Type type) {
  //  //    switch (type) {
  //  //    case FATAL:
  //  //      return WindowMessagePresenter.Type.ERROR;
  //  //    case WARNING:
  //  //      return WindowMessagePresenter.Type.WARNING;
  //  //    case INFO:
  //  //      return WindowMessagePresenter.Type.INFO;
  //  //    case ERROR:
  //  //      return WindowMessagePresenter.Type.ERROR;
  //  //    }
  //  //    return WindowMessagePresenter.Type.ERROR;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht alle Meldungen aus der Meldungsliste.</p>
  //  //   */
  //  //  public void clear() {
  //  //    clear("");
  //  //  }
  //  //
  //  //  /**
  //  //   * Löscht alle Meldungen aus der Meldungsliste mittels übergebenen Kategorie.
  //  //   *
  //  //   * @param pCategorie Kategorie als STRING. Ist die übergebene Kategorie "", werden alle Meldungen gelöscht.
  //  //   */
  //  //  public void clear(String... pCategorie) {
  //  //    assert pCategorie != null : "MessageFactory: Category is NULL";
  //  //    assert permanentMessagePresenterList.size() != 0 : "MessageFactory: no permanentMessagePresenter defined!";
  //  //
  //  //    for (String tCat : pCategorie) {
  //  //
  //  //      List<String> widgetsToClear = new ArrayList<>();
  //  //      List<GsMessage> gsMessageToClear = new ArrayList<>();
  //  //
  //  //      // Zusammensammeln der Widgets und Messages, die gelöscht werden sollen.
  //  //      for (GsMessage message : messageList) {
  //  //        // Kategorie übereinstimmend oder NULL?
  //  //        if ((tCat != null && tCat.equals(message.getCategory())) || tCat.isEmpty()) {
  //  //          for (String widgetId : message.getFieldInError()) {
  //  //            widgetsToClear.add(widgetId);
  //  //          }
  //  //          gsMessageToClear.add(message);
  //  //        }
  //  //      }
  //  //
  //  //      // Message-Presentern sowie die MessageList aufräumen
  //  //      for (MessagePresenter messagePresenter : permanentMessagePresenterList) {
  //  //        for (GsMessage message : gsMessageToClear) {
  //  //          messagePresenter.remove(message);
  //  //        }
  //  //      }
  //  //      for (GsMessage message : gsMessageToClear) {
  //  //        messageList.remove(message);
  //  //      }
  //  //
  //  //      // Widgets zurücksetzen
  //  //      for (String widgetId : widgetsToClear) {
  //  //        List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(widgetId);
  //  //        if (messagePresenterWidgets != null) {
  //  //          for (MessagePresenterWidget mpw : messagePresenterWidgets) {
  //  //            mpw.getWidget()
  //  //               .clearInvalid();
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  public boolean contains(GsMessage message) {
  //  //    return messageList.contains(message);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Zeigt eine Confirm-Message mit dem registrieten Confirm-Presenter an.</p>
  //  //   *
  //  //   * @param title   Titel des Confirm-Presenter
  //  //   * @param text    Text des Confirm-Presenter
  //  //   * @param command Command des Confirm-Presenter
  //  //   */
  //  //
  //  //  public void confirm(String title,
  //  //                      String text,
  //  //                      ConfirmCommand command) {
  //  //    assert confirmMessagePresenter != null : "MessageFactory: no ConfirmMessagePresenter defined!";
  //  //    confirmMessagePresenter.setUp(title,
  //  //                                  text,
  //  //                                  command);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Zeigt eine Confirm-Message mit dem registrieten Confirm-Presenter an.</p>
  //  //   *
  //  //   * @param title   Titel des Confirm-Presenter
  //  //   * @param text    Text des Confirm-Presenter
  //  //   * @param command Command des Confirm-Presenter
  //  //   */
  //  //  public void confirm(String title,
  //  //                      String text,
  //  //                      String buttonYesText,
  //  //                      int buttonYesWidth,
  //  //                      String buttonNoText,
  //  //                      int buttonNoWidth,
  //  //                      ConfirmCommand command) {
  //  //    assert confirmMessagePresenter != null : "MessageFactory: no ConfirmMessagePresenter defined!";
  //  //    confirmMessagePresenter.setUp(title,
  //  //                                  text,
  //  //                                  buttonYesText,
  //  //                                  buttonYesWidth,
  //  //                                  buttonNoText,
  //  //                                  buttonNoWidth,
  //  //                                  command);
  //  //  }
  //  //
  //  //  public void confirm(String title,
  //  //                      String text,
  //  //                      String buttonYesText,
  //  //                      String buttonNoText,
  //  //                      ConfirmCommand command) {
  //  //    confirm(title,
  //  //            text,
  //  //            buttonYesText,
  //  //            0,
  //  //            buttonNoText,
  //  //            0,
  //  //            command);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Zeigt eine Confirm-Message mit dem registrieten Confirm-Presenter an.</p>
  //  //   *
  //  //   * @param title   Titel des Confirm-Presenter
  //  //   * @param text    Text des Confirm-Presenter
  //  //   * @param command Command des Confirm-Presenter
  //  //   */
  //  //  public void confirm(String title,
  //  //                      String text,
  //  //                      String buttonYesText,
  //  //                      int buttonYesWidth,
  //  //                      String buttonCustomText,
  //  //                      int buttonCustomWidth,
  //  //                      String buttonNoText,
  //  //                      int buttonNoWidth,
  //  //                      ConfirmCustomCommand command) {
  //  //    assert confirmMessagePresenter != null : "MessageFactory: no ConfirmMessagePresenter defined!";
  //  //    confirmMessagePresenter.setUp(title,
  //  //                                  text,
  //  //                                  buttonYesText,
  //  //                                  buttonYesWidth,
  //  //                                  buttonCustomText,
  //  //                                  buttonCustomWidth,
  //  //                                  buttonNoText,
  //  //                                  buttonNoWidth,
  //  //                                  command);
  //  //  }
  //  //
  //  //  public void confirm(String title,
  //  //                      String text,
  //  //                      String buttonYesText,
  //  //                      String buttonCustomText,
  //  //                      String buttonNoText,
  //  //                      ConfirmCustomCommand command) {
  //  //    confirm(title,
  //  //            text,
  //  //            buttonYesText,
  //  //            0,
  //  //            buttonCustomText,
  //  //            0,
  //  //            buttonNoText,
  //  //            0,
  //  //            command);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Zeigt eine Confirm-Cancel-Message mit dem registrieten Confirm-Cancel-Presenter an.</p>
  //  //   *
  //  //   * @param command Command des Confirm-Cancel-Presenter
  //  //   */
  //  //  public void confirmCancel(ConfirmCommand command) {
  //  //    assert confirmCancelMessagePresenter != null : "MessageFactory: no ConfirmCancelMessagePresenter defined!";
  //  //    confirmCancelMessagePresenter.setUp(command);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht alle Meldungen die vom Server erzeugt wurden</p>
  //  //   */
  //  //  public void removeMessagesWithSourceServer() {
  //  //    this.removeMessagesWithSource(Source.SERVER);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht alle Meldungen die NICHT vom Client erzeugt wurden</p>
  //  //   */
  //  //  public void removeMessagesWithSourceNotClient() {
  //  //    for (int i = messageList.size() - 1; i > -1; i--) {
  //  //      if (!Source.CLIENT.equals(messageList.get(i)
  //  //                                           .getSource())) {
  //  //        remove(messageList.get(i));
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht alle Meldungen die NICHT permanent sind</p>
  //  //   */
  //  //  public void removeNonPermanentMessages() {
  //  //    for (int i = messageList.size() - 1; i > -1; i--) {
  //  //      if (!GsMessage.Visibility.PERMANENT.equals(messageList.get(i)
  //  //                                                            .getVisibility())) {
  //  //        remove(messageList.get(i));
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * Loescht alle Meldungen die die übergeben Source besitzen
  //  //   */
  //  //  private void removeMessagesWithSource(Source source) {
  //  //    assert source != null : "MessageFactory: Source is null!";
  //  //    for (int i = messageList.size() - 1; i > -1; i--) {
  //  //      if (source.equals(messageList.get(i)
  //  //                                   .getSource())) {
  //  //        remove(messageList.get(i));
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * Löscht alle Meldungen die die übergeben Kategorie besitzen
  //  //   */
  //  //  public void removeMessagesWithCategorie(String pCategorie) {
  //  //    assert pCategorie != null : "MessageFactory: Kategorie is null!";
  //  //    for (int i = messageList.size() - 1; i > -1; i--) {
  //  //      if (pCategorie.equals(messageList.get(i)
  //  //                                       .getCategory())) {
  //  //        remove(messageList.get(i));
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht alle Meldungen die vom Client erzeugt wurden</p>
  //  //   */
  //  //  public void removeMessagesWithSourceClient() {
  //  //    this.removeMessagesWithSource(Source.CLIENT);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht Meldungen der Felder mit den übergebenen IDs aus der Meldungsliste.</p>
  //  //   *
  //  //   * @param messageWidgetIds IDs der Felder, deren Meldungen geloescht werden sollen
  //  //   */
  //  //  public void removeMessagesForField(List<String> messageWidgetIds) {
  //  //    assert permanentMessagePresenterList.size() != 0 : "MessageFactory: no permanentMessagePresenter defined!";
  //  //    for (String identifier : messageWidgetIds) {
  //  //      removeMessagesFor(identifier);
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Loescht Meldungen eines Feldes mit den übergebenen IDs aus der Meldungsliste.</p>
  //  //   *
  //  //   * @param messageWidgetId ID des Felders, deren Meldungen geloescht werden sollen
  //  //   */
  //  //  public void removeMessagesFor(String messageWidgetId) {
  //  //    assert permanentMessagePresenterList.size() != 0 : "MessageFactory: no permanentMessagePresenter defined!";
  //  //    for (int i = messageList.size() - 1; i > -1; i--) {
  //  //      if (messageList.get(i)
  //  //                     .isMessageForMessagePresenter(messageWidgetId)) {
  //  //        List<String> messagePresenterIdentifierList = messageList.get(i)
  //  //                                                                 .getFieldInError();
  //  //        List<String> messagePresenterWithoutBlurHandlingIdentifierList = messageList.get(i)
  //  //                                                                                    .getMessageWidgetsWithoutBlurHandling();
  //  //        remove(messageList.get(i));
  //  //        for (String identifier : messagePresenterIdentifierList) {
  //  //          clearInvalidFor(identifier);
  //  //        }
  //  //        for (String identifier : messagePresenterWithoutBlurHandlingIdentifierList) {
  //  //          clearInvalidFor(identifier);
  //  //        }
  //  //      }
  //  //    }
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Entfernt die Fehlermarkierung vom Widget.</p>
  //  //   * <p>Wird ein Widget zu den Schluessel gefunden,
  //  //   * ist zu pruefen, ob das Widget ncoh eine weitere Fehlermeldung besitzt!</p>
  //  //   * <p>Achtung:<br/>
  //  //   * Diese MEhtode darf erst nach dem Entfernen der eigentlichen Meldung aufgerufen werden!</p>
  //  //   *
  //  //   * @param messageWidgetId die Field-ID
  //  //   */
  //  //  private void clearInvalidFor(String messageWidgetId) {
  //  //    if (messageWidgetId != null) {
  //  //      List<MessagePresenterWidget> messagePresenterWidgets = presenterWidgets.get(messageWidgetId);
  //  //      if (messagePresenterWidgets != null) {
  //  //        for (MessagePresenterWidget mpw : messagePresenterWidgets) {
  //  //          // Widget gefunden, jetzt pruefen, ob das Widget noch
  //  //          // fuer eine andere Fehlermeldung einen Fehler zu zeigen hat
  //  //          boolean canBeCleared = true;
  //  //          for (GsMessage message : messageList) {
  //  //            for (String fieldIdentifier : message.getFieldInError()) {
  //  //              if (fieldIdentifier.equals(messageWidgetId)) {
  //  //                canBeCleared = false;
  //  //                break;
  //  //              }
  //  //            }
  //  //          }
  //  //          if (canBeCleared) {
  //  //            mpw.getWidget()
  //  //               .clearInvalid();
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //  }

  /**
   * removes the progress bar from the screen
   */
  public void hideProgressBar() {
    progressBarPresenter.hide();
  }

  /**
   * Show the progress bar
   */
  public void showProgressBar() {
    showProgressBar(null);
  }

  /**
   * Show the progress bar with a custom message
   *
   * @param progressText message to display inside the progress bar
   */
  public void showProgressBar(String progressText) {
    assert progressBarPresenter != null : "MessageFactory: no ProgressBarPresenter defined!";
    progressBarActive = true;
    if (Objects.isNull(progressText)) {
      progressBarPresenter.showDefault();
    } else {
      progressBarPresenter.show(progressText);
    }
  }

  //  public boolean isProgressBarActive() {
  //    return progressBarActive;
  //  }
  //
  //  //  /**
  //  //   * <p>Anzeige der TechnicalErrorMessage mit den übergebenen Daten</p>
  //  //   *
  //  //   * @param messageText  Text der ProgressBar
  //  //   * @param headerText   Zusätzlich anzuzeigende Infos in der Headline (neben dem Text: techn. Fehler)
  //  //   * @param closeHandler CloseHandler des TechnicalErrorMessagePresenter
  //  //   */
  //  //  public void showTechnicalErrorMessage(SafeHtml messageText,
  //  //                                        String headerText,
  //  //                                        TechnicalErrorMessagePresenter.CloseHandler closeHandler) {
  //  //    assert technicalErrorMessagePresenter != null : "MessageFactory: no TechnicalErrorMessagePresenter defined!";
  //  //    technicalErrorMessagePresenter.setUp(messageText,
  //  //                                         headerText,
  //  //                                         closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeige der TechnicalErrorMessage mit den übergebenen Daten</p>
  //  //   *
  //  //   * @param messageText  Text der ProgressBar
  //  //   * @param closeHandler CloseHandler des TechnicalErrorMessagePresenter
  //  //   */
  //  //  public void showTechnicalErrorMessage(SafeHtml messageText,
  //  //                                        TechnicalErrorMessagePresenter.CloseHandler closeHandler) {
  //  //    showTechnicalErrorMessage(messageText,
  //  //                              null,
  //  //                              closeHandler);
  //  //  }
  //
  //  //  public void showDefaultProgressBarMasterLock() {
  //  //    masterlock = true;
  //  //    showDefaultProgressBar();
  //  //  }
  //  //
  //  //  public void hideProgressBar(String traceString) {
  //  //    assert progressBarPresenter != null : "MessageFactory: no ProgressBarPresenter defined!";
  //  //    if (!masterlock) {
  //  //      progressBarPresenter.hide();
  //  //      if (traceString == null) {
  //  //        GWT.log("MessageFactory: HIDE PROGRESSBAR");
  //  //      } else {
  //  //        GWT.log("MessageFactory: HIDE PROGRESSBAR at '" + traceString + "'");
  //  //      }
  //  //    } else {
  //  //      GWT.log("MessageFactory: HIDE PROGRESSBAR BLOCKED!");
  //  //    }
  //  //
  //  //  }
  //  //
  //  //  public void hideProgressBarMasterLock() {
  //  //    masterlock = false;
  //  //    hideProgressBar();
  //  //  }
  //  //
  //  //  public void setMasterLock(boolean value) {
  //  //    masterlock = value;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Fehlermeldung</p>
  //  //   *
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showErrorMessage(String message,
  //  //                               boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Fehlermeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param heading   Ueberschrift des Layers
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showErrorMessage(String heading,
  //  //                               String message,
  //  //                               boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Fehlermeldung</p>
  //  //   *
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showErrorMessage(String message,
  //  //                               boolean showIntro,
  //  //                               WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Fehlermeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showErrorMessage(String heading,
  //  //                               String message,
  //  //                               boolean showIntro,
  //  //                               WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Errormeldung</p>
  //  //   *
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showErrorMessage(List<String> messages,
  //  //                               boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Errormeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showErrorMessage(String heading,
  //  //                               List<String> messages,
  //  //                               boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Errormeldung</p>
  //  //   *
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showErrorMessage(List<String> messages,
  //  //                               boolean showIntro,
  //  //                               WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Errormeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showErrorMessage(String heading,
  //  //                               List<String> messages,
  //  //                               boolean showIntro,
  //  //                               WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.ERROR,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showInfoMessage(String message,
  //  //                              boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showInfoMessage(String heading,
  //  //                              String message,
  //  //                              boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showInfoMessage(String message,
  //  //                              boolean showIntro,
  //  //                              WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showInfoMessage(String heading,
  //  //                              String message,
  //  //                              boolean showIntro,
  //  //                              WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showInfoMessage(List<String> messages,
  //  //                              boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showInfoMessage(String heading,
  //  //                              List<String> messages,
  //  //                              boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showInfoMessage(List<String> messages,
  //  //                              boolean showIntro,
  //  //                              WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showInfoMessage(String heading,
  //  //                              List<String> messages,
  //  //                              boolean showIntro,
  //  //                              WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.INFO,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Warnungsmeldung</p>
  //  //   *
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showWarningMessage(String message,
  //  //                                 boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Warnungsmeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param message   Meldungstext
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showWarningMessage(String heading,
  //  //                                 String message,
  //  //                                 boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Warnungsmeldung</p>
  //  //   *
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showWarningMessage(String message,
  //  //                                 boolean showIntro,
  //  //                                 WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                null,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Warnungsmeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param message      Meldungstext
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showWarningMessage(String heading,
  //  //                                 String message,
  //  //                                 boolean showIntro,
  //  //                                 WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                heading,
  //  //                Collections.singletonList(message),
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showWarningMessage(List<String> messages,
  //  //                                 boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,  Heading des Layers
  //  //   * @param messages  Meldungstexte
  //  //   * @param showIntro true -> ein textualer Intro wird gezeigt
  //  //   */
  //  //  public void showWarningMessage(String heading,
  //  //                                 List<String> messages,
  //  //                                 boolean showIntro) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                null);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showWarningMessage(List<String> messages,
  //  //                                 boolean showIntro,
  //  //                                 WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                null,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Anzeigen einer Informationsmeldung</p>
  //  //   *
  //  //   * @param heading,     Heading des Layers
  //  //   * @param messages     Meldungstexte
  //  //   * @param showIntro    true -> ein textualer Intro wird gezeigt
  //  //   * @param closeHandler closeHandler, wird beim Schliessen der Meldung ausgefuehrt
  //  //   */
  //  //  public void showWarningMessage(String heading,
  //  //                                 List<String> messages,
  //  //                                 boolean showIntro,
  //  //                                 WindowMessagePresenter.CloseHandler closeHandler) {
  //  //    showMessage(WindowMessagePresenter.Type.WARNING,
  //  //                heading,
  //  //                messages,
  //  //                showIntro,
  //  //                closeHandler);
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Prueft, ob zu den übergebenen FieldIds eine Fehlermeldung vorliegt.</p>
  //  //   *
  //  //   * @param widgetIds Liste der zu pruefenden FieldIds
  //  //   * @return true ->  es exisitert mindestens eine Fehlermeldung zu den übergebenen FieldIds
  //  //   */
  //  //  public boolean hasErrorMessagesForWidgetIds(List<String> widgetIds) {
  //  //    for (String fieldId : widgetIds) {
  //  //      for (GsMessage message : messageList) {
  //  //        if (Type.ERROR.equals(message.getType()) || Type.FATAL.equals(message.getType())) {
  //  //          for (String fieldIdFromMessage : message.getFieldInError()) {
  //  //            if (fieldIdFromMessage.equals(fieldId)) {
  //  //              return true;
  //  //            }
  //  //          }
  //  //          for (String fieldIdFromMessage : message.getMessageWidgetsWithoutBlurHandling()) {
  //  //            if (fieldIdFromMessage.equals(fieldId)) {
  //  //              return true;
  //  //            }
  //  //          }
  //  //        }
  //  //      }
  //  //    }
  //  //    return false;
  //  //  }
  //  //
  //  //  /**
  //  //   * <p>Klasse zum Speichern von Widgets zur Fehleranzeige.</p>
  //  //   */
  //  //  private static class MessagePresenterWidget {
  //  //    private String messageWidgetId;
  //  //
  //  //    private HasGsMessagePresenterSupport widget;
  //  //
  //  //    MessagePresenterWidget(String messageWidgetId,
  //  //                           HasGsMessagePresenterSupport widget) {
  //  //      this.messageWidgetId = messageWidgetId;
  //  //      this.widget = widget;
  //  //    }
  //  //
  //  //    public String getFieldInError() {
  //  //      return messageWidgetId;
  //  //    }
  //  //
  //  //    public HasGsMessagePresenterSupport getWidget() {
  //  //      return widget;
  //  //    }
  //  //
  //  //  }

}
