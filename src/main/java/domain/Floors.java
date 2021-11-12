package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Floors {
    private final List<Floor> floors;

    public Floors() {
        floors = new ArrayList<>();
    }

    public void add(Floor floor) {
        floors.add(floor);
    }

    public Stream<Floor> stream() {
        return floors.stream();
    }
}
