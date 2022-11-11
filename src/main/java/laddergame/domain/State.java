package laddergame.domain;

import laddergame.Generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class State {

    private static final Map<Boolean, State> cache;
    private final boolean state;

    static {
        cache = new HashMap<>();
        cache.put(true, new State(true));
        cache.put(false, new State(false));
    }

    private State(boolean state) {
        this.state = state;
    }

    public static State valueOf(Boolean value) {
        return cache.get(value);
    }

    public State next(Generator generator) {
        boolean next = generator.generate();
        if (isExist()) {
            return new State(false);
        }
        return new State(next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        return state == state1.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    public String toString() {
        return "State{" +
                "state=" + state +
                '}';
    }

    public boolean isExist() {
        return this.state;
    }
}

