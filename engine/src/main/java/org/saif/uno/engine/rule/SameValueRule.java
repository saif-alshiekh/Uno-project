package org.saif.uno.engine.rule;

import com.google.common.collect.Iterables;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.state.State;

public final class SameValueRule extends StateDependantRule {

    public SameValueRule(State state, Card card) {
        super(state, card);
    }

    @Override
    public boolean apply() {
        return Iterables.getLast(state.playPile().cards()).value().equals(card.value());
    }

    @Override
    public String toString() {
        return "SameValueRule";
    }
}
