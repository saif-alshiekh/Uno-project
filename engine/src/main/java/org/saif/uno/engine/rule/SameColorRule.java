package org.saif.uno.engine.rule;

import com.google.common.collect.Iterables;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.state.State;

public final class SameColorRule extends StateDependantRule {

    public SameColorRule(State state, Card card) {
        super(state, card);
    }

    @Override
    public boolean apply() {

        return Iterables.getLast(state.playPile().cards()).color().equals(card.color());
    }

    @Override
    public String toString() {
        return "SameColorRule";
    }
}
