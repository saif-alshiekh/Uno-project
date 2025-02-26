package org.saif.uno.game;

import com.google.common.collect.Iterables;
import org.saif.uno.engine.render.Renderer;
import org.saif.uno.engine.state.State;

public class ConsoleGameRenderer implements Renderer {

    @Override
    public void render(State state) {
        System.out.println("Current Player: " + state.currentPlayer());
        System.out.println("Top of Play pile: " + Iterables.getLast(state.playPile().cards()));

        var deck = state.decks().decks().get(state.currentPlayer());
        int counter = 0;

        for (var card : deck.cards()) {
            System.out.println(counter + ") " + card);
            counter++;
        }
    }
}
