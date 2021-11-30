package domain;

import java.util.List;

public class Floors {
    private final List<Floor> floors;

    public Floors(List<Floor> floors) {
        this.floors = floors;
    }

    public int size() {
        return floors.size();
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
