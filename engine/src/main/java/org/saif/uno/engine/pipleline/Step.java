package org.saif.uno.engine.pipleline;

public interface Step<I, O> {

    O execute(I input);

    default <R> Step<I, R> pipe(Step<O, R> source) {
        return value -> source.execute(execute(value));
    }
}
