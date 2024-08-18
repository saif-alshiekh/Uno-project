package org.saif.uno.engine.rule;

import org.saif.uno.engine.action.NoEffectAction;
import org.saif.uno.engine.card.Card;

public final class HasActionRule extends StateInDependantRule {

    public HasActionRule(Card card) {
        super(card);
    }

    @Override
    public boolean apply() {
        return !(card.action() instanceof NoEffectAction);
    }

    @Override
    public String toString() {
        return "HasActionRule";
    }
}
