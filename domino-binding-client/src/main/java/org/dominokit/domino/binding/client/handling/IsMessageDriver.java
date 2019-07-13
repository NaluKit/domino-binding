package org.dominokit.domino.binding.client.handling;

import org.dominokit.domino.binding.shared.model.IsDominoMessage;

import java.util.List;

public interface IsMessageDriver<P extends IsMessageProvider> {

  /**
   * Used to add messags to the MessageFactory and make them visible
   *
   * @param messages messages to display
   */
  void consume(List<? extends IsDominoMessage> messages);

  /**
   * clears all error messages
   */
  void clearInvalid();

  /**
   * Deregister the driver
   */
  void deregister();

  /**
   * Deregister and destroy the driver
   */
  void deregisterAndDestroy();

  /**
   * Destroy the driver
   */
  void destroy();

  /**
   * Initialize the driver
   *
   * @param messageProvider container with message presentr
   */
  void initialize(P messageProvider);

  /**
   * Register the driver
   */
  void register();

}
