package domain;

import java.util.List;

public class Floor {
    private List<Boolean> states;

    public Floor(List<Boolean> states) {
        this.states = states;
    }

    public List<Boolean> provideStatesOfStair() {
        return states;
    }
}
