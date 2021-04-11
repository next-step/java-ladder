package nextstep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coordinates {
    private final List<Coordinate> coordinates;

    public Coordinates() {
        this.coordinates = new ArrayList<>();
    }

    public void add(Coordinate coordinate) {
        this.coordinates.add(coordinate);
    }

    public int size() {
        return this.coordinates.size();
    }

    public void move(int target) {
        coordinates.get(target).move();
    }

    public List<Integer> heights() {
        return this.coordinates.stream()
                .map(Coordinate::getHeight)
                .collect(Collectors.toList());
    }
}
