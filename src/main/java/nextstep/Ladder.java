package nextstep;

import nextstep.exception.DuplicateException;

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

    public void add(String name, int width) throws DuplicateException {
        Coordinate coordinate = new Coordinate(name, width, this.height);
        if (contains(coordinate)) {
            throw new DuplicateException("Duplicate");
        }
        this.coordinates.add(coordinate);
    }

    private boolean contains(Coordinate coordinate) {
        return this.coordinates.contains(coordinate);
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
