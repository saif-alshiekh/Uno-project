package org.saif.uno.game.events;

import org.saif.uno.engine.action.DefaultActionVisitor;
import org.saif.uno.engine.event.EventHandler;
import org.saif.uno.engine.rule.*;
import org.saif.uno.engine.state.State;

public final class CardChosenEventHandler implements EventHandler<CardChosenEvent> {

    @Override
    public State handle(State state, CardChosenEvent event) throws Exception {
        var ruleSet = new RuleSet(false, (p, c) -> c.apply() || p)
                .add(new RuleSet()
                        .add(new HasValueRule(event.card()))
                        .add(new HasValueRule(state.topOfPlayPile()))
                        .add(new SameValueRule(state, event.card()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasValueRule(event.card()))
                        .add(new HasValueRule(state.topOfPlayPile()))
                        .add(new DifferentValueRule(state, event.card()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasValueRule(event.card()))
                        .add(new HasValueRule(state.topOfPlayPile()))
                        .add(new SameValueRule(state, event.card()))
                        .add(new DifferentColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasValueRule(event.card()))
                        .add(new HasActionRule(state.topOfPlayPile()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasValueRule(event.card()))
                        .add(new WildCardRule(state.topOfPlayPile())))
                .add(new RuleSet()
                        .add(new HasActionRule(event.card()))
                        .add(new HasValueRule(state.topOfPlayPile()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasActionRule(event.card()))
                        .add(new WildCardRule(state.topOfPlayPile())))
                .add(new RuleSet()
                        .add(new HasActionRule(event.card()))
                        .add(new HasActionRule(state.topOfPlayPile()))
                        .add(new SameActionRule(state, event.card()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasActionRule(event.card()))
                        .add(new HasActionRule(state.topOfPlayPile()))
                        .add(new SameActionRule(state, event.card()))
                        .add(new DifferentColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new HasActionRule(event.card()))
                        .add(new HasActionRule(state.topOfPlayPile()))
                        .add(new DifferentActionRule(state, event.card()))
                        .add(new SameColorRule(state, event.card())))
                .add(new RuleSet()
                        .add(new WildCardRule(event.card())));

        if (!ruleSet.apply()) {
            System.out.println("You can't place this card now, pick another or draw form the bank");
            return state;
        }

        var stateAfterAction = event.card()
                .action()
                .accept(new DefaultActionVisitor(state));

        return stateAfterAction
                .withPlayPile(event.card())
                .withDecks(stateAfterAction.decks().remove(event.card()));
    }
}
