package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Floors {

    private final List<Floor> floors;

    public Floors() {
        this.floors = new ArrayList<>();
    }

    public void produceFloor(List<Boolean> randomGeneratedFloorStates) {
        floors.add(new Floor(randomGeneratedFloorStates));
    }

    public Stream<Floor> stream() {
        return floors.stream();
    }

    public int size() {
        return floors.size();
    }
}
