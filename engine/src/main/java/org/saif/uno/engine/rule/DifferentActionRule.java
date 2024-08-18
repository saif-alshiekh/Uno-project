package org.saif.uno.engine.rule;

import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.state.State;

public final class DifferentActionRule extends StateDependantRule {

    public DifferentActionRule(State state, Card card) {
        super(state, card);
    }

    @Override
    public boolean apply() {
        return !(new SameActionRule(state, card).apply());
    }

    @Override
    public String toString() {
        return "DifferentActionRule";
    }
}
