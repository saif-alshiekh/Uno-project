package org.saif.uno.game.events;

import org.saif.uno.engine.event.EventHandler;
import org.saif.uno.engine.state.State;

public final class EndGameEventHandler implements EventHandler<EndGameEvent> {

    @Override
    public State handle(State state, EndGameEvent event) throws Exception {
        System.out.println("The game has ended!, " + state.currentPlayer() + " has won!");
        return state;
    }
}
