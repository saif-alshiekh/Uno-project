package org.saif.uno.engine.rule;

import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.state.State;

public final class DifferentColorRule extends StateDependantRule {
    public DifferentColorRule(State state, Card card) {
        super(state, card);
    }

    @Override
    public boolean apply() {
        return !state.topOfPlayPile().color().equals(card.color());
    }

    @Override
    public String toString() {
        return "DifferentColorRule";
    }
}
