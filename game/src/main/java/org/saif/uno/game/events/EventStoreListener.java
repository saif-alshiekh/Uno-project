package org.saif.uno.game.events;

import org.saif.uno.engine.event.StateListener;
import org.saif.uno.engine.render.Renderer;
import org.saif.uno.engine.state.State;

public final class EventStoreListener implements StateListener<State> {
    final Renderer renderer;

    public EventStoreListener(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void call(State oldState, State newState) {
        if (oldState == newState) return;
        renderer.render(newState);
    }
}
