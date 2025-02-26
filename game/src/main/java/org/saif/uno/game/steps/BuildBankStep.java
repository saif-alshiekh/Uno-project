package org.saif.uno.game.steps;

import org.saif.uno.engine.Color;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.pipleline.Pipeline;
import org.saif.uno.engine.pipleline.Step;
import org.saif.uno.engine.state.State;
import org.saif.uno.engine.structures.Pile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildBankStep implements Step<State, State> {

    @Override
    public State execute(State currentState) {

        final var bank = new Pipeline<List<Card>, List<Card>>()
                .add(new ActionCardsStep(Color.Red))
                .add(new ActionCardsStep(Color.Green))
                .add(new ActionCardsStep(Color.Blue))
                .add(new ActionCardsStep(Color.Yellow))
                .add(new ValueCardsStep(Color.Red))
                .add(new ValueCardsStep(Color.Green))
                .add(new ValueCardsStep(Color.Blue))
                .add(new ValueCardsStep(Color.Yellow))
                .add(new WildCardsStep())
                .run(new ArrayList<>());

        Collections.shuffle(bank);
        return currentState.withBankPile(new Pile(bank));
    }
}
