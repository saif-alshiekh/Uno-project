package org.saif.uno.engine.rule;

import org.saif.uno.engine.card.Card;

public final class HasNoValueRule extends StateInDependantRule {

    public HasNoValueRule(Card card) {
        super(card);
    }

    @Override
    public boolean apply() {
        return !(new HasValueRule(card).apply());
    }

    @Override
    public String toString() {
        return "HasNoValueRule";
    }
}
