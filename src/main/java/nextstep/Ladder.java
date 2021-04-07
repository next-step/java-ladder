package nextstep;

import nextstep.exception.DuplicateException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Coordinate> coordinates;
    private final int height;

    public Ladder(int height) {
        this.height = height;
        this.coordinates = new ArrayList<>();
    }

    public void add(int width) throws DuplicateException {
        Coordinate coordinate = new Coordinate(width, this.height);
        if (contains(coordinate)) {
            throw new DuplicateException("Duplicate");
        }
        this.coordinates.add(coordinate);
    }

    private boolean contains(Coordinate coordinate) {
        return this.coordinates.contains(coordinate);
    }

    public void move() {
    }

    public List<Integer> heights() {
        return null;
    }
}
