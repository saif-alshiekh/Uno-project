package org.saif.uno.engine.action;

import org.saif.uno.engine.state.State;

final public class ReverseAction implements Action {

    @Override
    public String representation() {
        return "Reverse";
    }
    @Override
    public State accept(ActionStateVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ReverseAction;
    }
}
