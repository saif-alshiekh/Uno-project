package org.saif.uno.game.events;

import org.saif.uno.engine.card.Card;
import org.saif.uno.engine.event.Event;

public record CardChosenEvent(Card card) implements Event {

}
