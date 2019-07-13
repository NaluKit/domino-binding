# domino-error-binding
Domino-error-binding is a lib for showing errors on the client side created by the server.

## Motivation
Many times validation is done on the server side. In this case we mostly can only display a message, but are not able to mark the fields in error. This libs will provide a solution to show this error message on the related element.

## Idea
Expecting that error messages are created by validation in case of uptating or inserting a model, we can assume, that the related widgets are attached and in focus. To get these kind of showing error messages work, we will use a naming convention. When creating a error message, we will set a name to identify the widget/widgets to display the message. On the client side we will add these name by using an annotation.

// TODO
