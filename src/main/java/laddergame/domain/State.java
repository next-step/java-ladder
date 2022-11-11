package laddergame.domain;

import java.util.Objects;

public class State {
    private final boolean state;

    public State(boolean state) {
        this.state = state;
    }

    public State next(boolean state) {
        if (this.state) {
            return new State(false);
        }
        return new State(state);
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
}

