package domain;

import java.util.List;

public class Floor {
    private final List<Boolean> states;

    public Floor(List<Boolean> states) {
        this.states = states;
    }

    public List<Boolean> getStates() {
        return states;
    }
}
