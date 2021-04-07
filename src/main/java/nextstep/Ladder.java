package nextstep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Coordinate> coordinates;
    private final int height;

    public Ladder(int height) {
        this.height = height;
        this.coordinates = new ArrayList<>();
    }

    public void add(String name) {
        Coordinate coordinate = new Coordinate(name, coordinates.size()+1, this.height);
        this.coordinates.add(coordinate);
    }

    public void move() {
        Optional<Coordinate> first = coordinates.stream()
                .findFirst();
        first.get().move();
    }

    public List<Integer> heights() {
        return coordinates.stream()
                .map(Coordinate::getHeight)
                .collect(Collectors.toList());
    }
}
