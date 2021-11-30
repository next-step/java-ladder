package domain;

import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
