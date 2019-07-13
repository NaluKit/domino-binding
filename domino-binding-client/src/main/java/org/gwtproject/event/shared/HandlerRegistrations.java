/*
 * Copyright 2013 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.event.shared;

/**
 * A utility class to help deal with {@link org.gwtproject.event.shared.HandlerRegistration handler registrations}.
 */
public class HandlerRegistrations {

  /**
   * For know this is a utility class, make it not instantiable.
   */
  private HandlerRegistrations() {
  }

  /**
   * Create and return a {@link org.gwtproject.event.shared.HandlerRegistration} that will call {@link
   * org.gwtproject.event.shared.HandlerRegistration#removeHandler()} on all supplied handlers if {@link
   * org.gwtproject.event.shared.HandlerRegistration#removeHandler()} is called on the returned object.
   *
   * <p>A simple example:
   *
   * <pre>
   * HandlerRegistration hr1 = ...
   * HandlerRegistration hr2 = ...
   * return HandlerRegistrations.compose(hr1, hr2);
   * </pre>
   *
   * @param handlers the {@link org.gwtproject.event.shared.HandlerRegistration handler registrations} that should be composed
   *                 into a single {@link org.gwtproject.event.shared.HandlerRegistration}
   * @return the composed {@link org.gwtproject.event.shared.HandlerRegistration}
   */
  public static HandlerRegistration compose(HandlerRegistration... handlers) {
    return new HandlerRegistrationCollection(handlers);
  }

  private static class HandlerRegistrationCollection
      implements HandlerRegistration {

    private HandlerRegistration[] handlers;

    public HandlerRegistrationCollection(HandlerRegistration... handlers) {
      this.handlers = handlers;
    }

    @Override
    public void removeHandler() {
      if (handlers == null) {
        return;
      }
      for (HandlerRegistration hr : handlers) {
        hr.removeHandler();
      }
      // make sure we remove the handlers to avoid potential leaks
      // if someone fails to null out their reference to us
      handlers = null;
    }

  }

}
