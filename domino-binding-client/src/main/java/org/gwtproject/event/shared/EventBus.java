/*
 * Copyright 2011 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.event.shared;

import org.gwtproject.event.shared.Event.Type;

/**
 * Dispatches {@link org.gwtproject.event.shared.Event}s to interested parties. Eases decoupling by allowing objects to interact
 * without having direct dependencies upon one another, and without requiring event sources to deal
 * with maintaining handler lists. There will typically be one EventBus per application,
 * broadcasting events that may be of general interest.
 *
 * @see org.gwtproject.event.shared.SimpleEventBus
 * @see org.gwtproject.event.shared.ResettableEventBus
 */
public abstract class EventBus
    implements HasHandlers {

  /**
   * Invokes {@code event.dispatch} with {@code handler}.
   *
   * <p>Protected to allow EventBus implementations in different packages to dispatch events even
   * though the {@code event.dispatch} method is protected.
   *
   * @param <H>     the event handler type
   * @param event   the event
   * @param handler the handler
   */
  protected static <H> void dispatchEvent(Event<H> event,
                                          H handler) {
    event.dispatch(handler);
  }

  /**
   * Sets {@code source} as the source of {@code event}.
   *
   * <p>Protected to allow EventBus implementations in different packages to set an event source
   * even though the {@code event.setSource} method is protected.
   *
   * @param event  the event
   * @param source the source
   */
  protected static void setSourceOfEvent(Event<?> event,
                                         Object source) {
    event.setSource(source);
  }

  /**
   * Adds an unfiltered handler to receive events of this type from all sources.
   *
   * <p>It is rare to call this method directly. More typically an {@link org.gwtproject.event.shared.Event} subclass will
   * provide a static <code>register</code> method, or a widget will accept handlers directly.
   *
   * @param <H>     The type of handler
   * @param type    the event type associated with this handler
   * @param handler the handler
   * @return the handler registration, can be stored in order to remove the handler later
   */
  public abstract <H> HandlerRegistration addHandler(Type<H> type,
                                                     H handler);

  /**
   * Adds a handler to receive events of this type from the given source.
   *
   * <p>It is rare to call this method directly. More typically a {@link org.gwtproject.event.shared.Event} subclass will
   * provide a static <code>register</code> method, or a widget will accept handlers directly.
   *
   * @param <H>     The type of handler
   * @param type    the event type associated with this handler
   * @param source  the source associated with this handler
   * @param handler the handler
   * @return the handler registration, can be stored in order to remove the handler later
   */
  public abstract <H> HandlerRegistration addHandlerToSource(Type<H> type,
                                                             Object source,
                                                             H handler);

  /**
   * Fires the event from no source. Only unfiltered handlers will receive it.
   *
   * <p>Any exceptions thrown by handlers will be bundled into a {@link org.gwtproject.event.shared.UmbrellaException} and then
   * re-thrown after all handlers have completed. An exception thrown by a handler will not prevent
   * other handlers from executing.
   *
   * @param event the event to fire
   * @throws org.gwtproject.event.shared.UmbrellaException wrapping exceptions thrown by handlers
   */
  @Override
  public abstract void fireEvent(Event<?> event);

  /**
   * Fires the given event to the handlers listening to the event's type.
   *
   * <p>Any exceptions thrown by handlers will be bundled into a {@link org.gwtproject.event.shared.UmbrellaException} and then
   * re-thrown after all handlers have completed. An exception thrown by a handler will not prevent
   * other handlers from executing.
   *
   * @param event  the event to fire
   * @param source the source of the event
   * @throws org.gwtproject.event.shared.UmbrellaException wrapping exceptions thrown by handlers
   */
  public abstract void fireEventFromSource(Event<?> event,
                                           Object source);

}
