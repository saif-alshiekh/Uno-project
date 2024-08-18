package org.saif.uno.game;

import org.saif.uno.engine.Game;
import org.saif.uno.game.events.*;
import org.saif.uno.engine.event.EventStore;
import org.saif.uno.engine.pipleline.Pipeline;
import org.saif.uno.engine.render.Renderer;
import org.saif.uno.engine.state.State;
import org.saif.uno.engine.structures.Deck;
import org.saif.uno.game.steps.BuildBankStep;
import org.saif.uno.game.steps.BuildDecksStep;
import org.saif.uno.game.steps.BuildPlayPileStep;
import org.saif.uno.game.steps.PickPlayerCountStep;

import java.util.Scanner;

public class ConsoleGame implements Game {
    @Override
    public void run() throws Exception {
        final Renderer renderer = new ConsoleGameRenderer();

        var initialState = new Pipeline<State, State>()
                .add(new PickPlayerCountStep())
                .add(new BuildBankStep())
                .add(new BuildDecksStep())
                .add(new BuildPlayPileStep())
                .run(new State());

        final EventStore eventStore = new EventStore()
                .registerHandler(DrawFromBankPileEvent.class, new DrawFromBankPileEventHandler())
                .registerHandler(CardChosenEvent.class, new CardChosenEventHandler())
                .registerHandler(EndGameEvent.class, new EndGameEventHandler())
                .registerListener(new EventStoreListener(renderer))
                .setState(initialState);

        var scanner = new Scanner(System.in);
        while (true) {
            final var currentState = eventStore.currentState();
            if (currentState.decks().stream().anyMatch(Deck::isEmpty)) {
                eventStore.addEvent(new EndGameEvent());
                break;
            }

            System.out.println("To draw a random card from the bank pile enter -1");

            var cardIndex = scanner.nextInt();
            if (cardIndex >= currentState.currentPlayerDeck().size()) {
                System.out.println("Choose a valid card!");
                continue;
            }

            if (cardIndex == -1) {
                eventStore.addEvent(new DrawFromBankPileEvent());
                continue;
            }

            var chosenCard = currentState.decks()
                    .get(currentState.currentPlayer())
                    .get(cardIndex);

            eventStore.addEvent(new CardChosenEvent(chosenCard));
        }
    }
}