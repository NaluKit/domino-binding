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

/**
 * Base Event object.
 *
 * @param <H> interface implemented by handlers of this kind of event
 */
public abstract class Event<H> {

  private Object source;

  /**
   * Constructor.
   */
  protected Event() {
  }

  /**
   * Returns the {@link Type} used to register this event, allowing an {@link org.gwtproject.event.shared.EventBus} to find
   * handlers of the appropriate class.
   *
   * @return the type
   */
  public abstract Type<H> getAssociatedType();

  /**
   * Returns the source for this event. The type and meaning of the source is arbitrary, and is most
   * useful as a secondary key for handler registration. (See {@link org.gwtproject.event.shared.EventBus#addHandlerToSource},
   * which allows a handler to register for events of a particular type, tied to a particular
   * source.)
   *
   * <p>Note that the source is actually set at dispatch time, e.g. via {@link
   * org.gwtproject.event.shared.EventBus#fireEventFromSource(org.gwtproject.event.shared.Event, Object)}.
   *
   * @return object representing the source of this event
   */
  public Object getSource() {
    return source;
  }

  /**
   * Set the source that triggered this event. Intended to be called by the {@link org.gwtproject.event.shared.EventBus} during
   * dispatch.
   *
   * @param source the source of this event.
   * @see org.gwtproject.event.shared.EventBus#fireEventFromSource(org.gwtproject.event.shared.Event, Object)
   * @see org.gwtproject.event.shared.EventBus#setSourceOfEvent(org.gwtproject.event.shared.Event, Object)
   */
  protected void setSource(Object source) {
    this.source = source;
  }

  /**
   * This is a method used primarily for debugging. It gives a string representation of the event
   * details. This does not override the toString method because the compiler cannot always optimize
   * toString out correctly. Event types should override as desired.
   *
   * @return a string representing the event's specifics.
   */
  public String toDebugString() {
    String name = this.getClass()
                      .getName();
    name = name.substring(name.lastIndexOf(".") + 1);
    return "event: " + name + ":";
  }

  /**
   * The toString() for abstract event is overridden to avoid accidently including class literals in
   * the compiled output. Use {@link org.gwtproject.event.shared.Event} #toDebugString to get more information about the event.
   */
  @Override
  public String toString() {
    return "An event type";
  }

  /**
   * Implemented by subclasses to to invoke their handlers in a type safe manner. Intended to be
   * called by {@link org.gwtproject.event.shared.EventBus#fireEvent(org.gwtproject.event.shared.Event)} or {@link org.gwtproject.event.shared.EventBus#fireEventFromSource(org.gwtproject.event.shared.Event,
   * Object)}.
   *
   * @param handler handler
   * @see org.gwtproject.event.shared.EventBus#dispatchEvent(org.gwtproject.event.shared.Event, Object)
   */
  protected abstract void dispatch(H handler);

  /**
   * Type class used to register events with an {@link org.gwtproject.event.shared.EventBus}.
   *
   * @param <H> handler type
   */
  public static class Type<H> {

    private static int nextHashCode;

    private final int index;

    /**
     * Constructor.
     */
    public Type() {
      index = ++nextHashCode;
    }

    @Override
    public final int hashCode() {
      return index;
    }

    @Override
    public String toString() {
      return "Event type";
    }

  }

}
