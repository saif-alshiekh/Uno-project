package org.saif.uno.engine.action;

import org.saif.uno.engine.state.State;

final public class WildDrawFourAction implements Action {
    @Override
    public String representation() {
        return "WildDrawFour";
    }

    @Override
    public State accept(ActionStateVisitor visitor) throws Exception {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof WildDrawFourAction;
    }
}
