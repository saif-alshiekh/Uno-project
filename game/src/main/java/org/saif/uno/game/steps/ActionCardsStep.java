package org.saif.uno.game.steps;

import org.saif.uno.engine.Color;
import org.saif.uno.engine.action.DrawTwoAction;
import org.saif.uno.engine.action.ReverseAction;
import org.saif.uno.engine.action.SkipAction;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.pipleline.Step;
import org.saif.uno.engine.value.EmptyCardValue;

import java.util.List;

public record ActionCardsStep(Color color) implements Step<List<Card>, List<Card>> {

    @Override
    public List<Card> execute(List<Card> input) {

        for (int i = 0; i < 2; i++) {
            input.add(new Card(new ReverseAction(), color, new EmptyCardValue()));
            input.add(new Card(new SkipAction(), color, new EmptyCardValue()));
            input.add(new Card(new DrawTwoAction(), color, new EmptyCardValue()));
        }
        return input;
    }
}
