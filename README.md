# domino-binding
Domino-binding is a lib for showing error nessages and tool tips on a widget of the client side created by the server.

## Motivation
* Many times validation is done on the server side. In this case we mostly can only display a message, but are not able to mark the field in error. This libs will provide a solution to show error message coming form the server on the related element.

* Also, we might want to display tool tips created by the server on a widget.

## Idea
Expecting that error messages are created by validation in case of uptating or inserting a model, we can assume, that the related widgets are attached and in focus. To get these kind of showing error messages work, we will use a naming convention. When creating a error message, we will set a name to identify the widget/widgets to display the message.

## Using

### On the client side
On the client side we will add these name by using an annotation:

```java
  @MessagePresenter("field01")
  TextBox tbField01;
```

Now, the widget represented by the instance of `tbField01` is bound to the name 'field01'.

Next we need to tell, that the class containing the widget is a Message Provider by adding the interface `IsMessageProvider`  annotating the class with `@HasMessageDriverSupport()`.

The last step we have to do is creating a message driver. To do so, we need to create

1. an instance variable `private IsMessageDriver<MyComponent> messageDriver;`

2. and creating the driver.

The driver is creating with the following code:

```java
    this.messageDriver = new MyComponentMessageDriverImpl();
    this.messageDriver.initialize(this);
    this.messageDriver.register();
```

### The shared Message Object
Next we need a message object to transport the information. The message object needs to implement the ÌsDominoMessage`-interface:

```java
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
```

### Creating a Message


## Example
An implementation of the binding feature can be found here: [Domino-Binidng-Example](https://github.com/NaluKit/domino-binding-example)

## Note
At the moment this is only a proof of concept.

// TODO
