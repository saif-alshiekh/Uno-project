package org.saif.uno.game.steps;

import org.saif.uno.engine.Color;
import org.saif.uno.engine.action.WildAction;
import org.saif.uno.engine.action.WildDrawFourAction;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.pipleline.Step;
import org.saif.uno.engine.value.EmptyCardValue;

import java.util.List;

public record WildCardsStep() implements Step<List<Card>, List<Card>> {

    @Override
    public List<Card> execute(List<Card> input) {

        for (int i = 0; i < 4; i++)
            input.add(new Card(new WildAction(), Color.NoColor, new EmptyCardValue()));
        for (int i = 0; i < 4; i++)
            input.add(new Card(new WildDrawFourAction(), Color.NoColor, new EmptyCardValue()));

        return input;
    }
}
