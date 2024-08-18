package org.saif.uno.game.steps;

import org.saif.uno.engine.pipleline.Step;
import org.saif.uno.engine.state.State;
import org.saif.uno.engine.value.EmptyCardValue;

import java.util.Objects;

public class BuildPlayPileStep implements Step<State, State> {
    @Override
    public State execute(State input) {
        try {
            var result = input.bankPile().getRandom(1, card -> !Objects.equals(card.value(), new EmptyCardValue()));
            return input
                    .withBankPile(result.first())
                    .withPlayPile(result.second().get(0));
        } catch (Exception e) {
            return input;
        }
    }
}
