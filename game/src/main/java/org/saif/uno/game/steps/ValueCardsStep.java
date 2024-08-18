package org.saif.uno.game.steps;

import org.saif.uno.engine.Color;
import org.saif.uno.engine.action.NoEffectAction;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.pipleline.Step;
import org.saif.uno.engine.value.CardValue;

import java.util.List;

public record ValueCardsStep(Color color) implements Step<List<Card>, List<Card>> {

    @Override
    public List<Card> execute(List<Card> input) {

        for (int i = 0; i <= 9; i++) {
            input.add(new Card(new NoEffectAction(), color, new CardValue(i)));
        }
        for (int i = 1; i <= 9; i++) {
            input.add(new Card(new NoEffectAction(), color, new CardValue(i)));
        }
        return input;
    }
}
