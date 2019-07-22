package org.dominokit.domino.binding.message.client.presenter;

/**
 * interfaces that defines the methods of a progress bar presenter
 */
public interface IsProgressBarPresenter {

  /**
   * Hides the progress bar
   */
  void hide();

  /**
   * Shows the progress bar using the default message
   */
  void showDefault();

  /**
   * Shows the progressbar using the message parameter
   *
   * @param message test of the progressbar
   */
  void show(String message);

}
