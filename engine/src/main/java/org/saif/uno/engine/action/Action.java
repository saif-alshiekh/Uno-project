package org.saif.uno.engine.action;

import org.saif.uno.engine.state.State;

public interface Action {
    String representation();

    State accept(ActionStateVisitor visitor) throws Exception;
}

