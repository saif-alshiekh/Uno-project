package org.saif.uno.engine.event;

import org.saif.uno.engine.state.State;

public interface StateListener<T extends State> {
    void call(State oldState, State newState);
}
