package domain;

import java.util.List;

public class Floors {
    private List<Floor> floors;

    public void add(Floor floor) {
        floors.add(floor);
    }

    public List<Floor> provideFloorInfo() {
        return floors;
    }
}
