package domain;

import java.util.List;

public class Ladder {
    private final Floors floors;

    public Ladder(Floors floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors.getFloors();
    }
}
