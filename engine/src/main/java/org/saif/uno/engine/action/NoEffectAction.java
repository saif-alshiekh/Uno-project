package org.saif.uno.engine.action;

import org.saif.uno.engine.state.State;

public class NoEffectAction implements Action {
    @Override
    public String representation() {
        return "";
    }
    @Override
    public State accept(ActionStateVisitor visitor) {
        return visitor.visit(this);
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof NoEffectAction;
    }
}
