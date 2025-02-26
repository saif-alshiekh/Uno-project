package org.saif.uno.engine.structures;

import io.soabase.recordbuilder.core.RecordBuilder;
import org.saif.uno.engine.card.Card;

import java.util.ArrayList;
import java.util.List;

@RecordBuilder
public record Deck(List<Card> cards) implements DeckBuilder.With {
    Deck() {
        this(new ArrayList<>());
    }

    public Deck remove(Card card) {
        List<Card> updated = new ArrayList<>(cards);
        updated.remove(card);
        return this.withCards(updated);
    }

    boolean isEmpty() {
        return cards.isEmpty();
    }

    public static boolean isEmpty(Deck deck) {
        return deck.isEmpty();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public Deck add(List<Card> cards) {
        var cardsCopy = new ArrayList<>(this.cards);
        cardsCopy.addAll(cards);
        return this.withCards(cardsCopy);
    }
}
