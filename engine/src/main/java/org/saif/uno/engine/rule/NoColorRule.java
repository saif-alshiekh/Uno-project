package org.saif.uno.engine.rule;

import org.saif.uno.engine.Color;
import org.saif.uno.engine.card.Card;

public final class NoColorRule extends StateInDependantRule {

    public NoColorRule(Card card) {
        super(card);
    }

    @Override
    public boolean apply() {
        return card.color().equals(Color.NoColor);
    }

    @Override
    public String toString() {
        return "NoEffectActionRule";
    }
}
