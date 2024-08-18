package org.saif.uno.engine.rule;

import org.saif.uno.engine.card.Card;

public final class WildCardRule extends StateInDependantRule {

    public WildCardRule(Card card) {
        super(card);
    }

    @Override
    public boolean apply() {
        return new RuleSet()
                .add(new NoColorRule(card))
                .add(new HasNoValueRule(card))
                .apply();
    }
}
