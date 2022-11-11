package laddergame.domain;

import java.util.List;

public class Row {
    private final List<State> state;

    public Row(List<State> state) {
        this.state = state;
    }

    public List<State> getStates() {
        return this.state;
    }
}
