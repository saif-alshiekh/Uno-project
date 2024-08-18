package org.saif.uno.engine.rule;

import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.state.State;

public final class SameActionRule extends StateDependantRule {

    public SameActionRule(State state, Card card) {
        super(state, card);
    }

    @Override
    public boolean apply() {

        return state.topOfPlayPile().action().equals(card.action());
    }

    @Override
    public String toString() {
        return "SameActionRule";
    }
}
