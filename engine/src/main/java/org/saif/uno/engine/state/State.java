package org.saif.uno.engine.state;

import io.soabase.recordbuilder.core.RecordBuilder;
import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.structures.Deck;
import org.saif.uno.engine.structures.Decks;
import org.saif.uno.engine.structures.Pile;

import java.util.List;

@RecordBuilder
public record State(
        int playerCount,
        Pile bankPile,
        Decks decks,
        Pile playPile,
        int currentPlayer,
        int direction) implements StateBuilder.With {

    public State() {

        this(0, new Pile(), new Decks(), new Pile(), 0, 1);
    }

    public int nextPlayer() {
        return Math.floorMod(currentPlayer + direction, playerCount);
    }

    public State withNextPlayer() {
        return this.withCurrentPlayer(nextPlayer());
    }

    public State withReversedDirection() {
        return this.withDirection(direction == 1 ? -1 : 1);
    }

    public Deck getDeck(int index) {
        return decks.get(index);
    }

    public Card topOfPlayPile() {
        return playPile.last();
    }

    public State withPlayPile(Card card) {
        return this.withPlayPile(playPile.withCard(card));
    }

    public List<Card> currentPlayerDeck() {
        return decks.get(currentPlayer).cards();
    }
}
