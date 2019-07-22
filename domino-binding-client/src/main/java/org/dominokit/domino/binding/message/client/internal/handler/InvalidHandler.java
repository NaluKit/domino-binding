package org.dominokit.domino.binding.message.client.internal.handler;

import elemental2.dom.Element;
import org.dominokit.domino.binding.message.shared.model.IsDominoMessage;

import java.util.List;

@FunctionalInterface
public interface InvalidHandler {

  void onInvalid(Element element,
                 List<IsDominoMessage> messages);

}

