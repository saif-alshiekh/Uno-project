package org.saif.uno.engine.event;

import org.saif.uno.engine.state.State;

public interface EventHandler<T extends Event> {
    State handle(State currentState, T event) throws Exception;
}
