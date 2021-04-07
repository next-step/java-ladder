package nextstep;

import nextstep.exception.DuplicateException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Coordinate> coordinates;

    public Ladder() {
        this.coordinates = new ArrayList<>();
    }

    public void add(Coordinate coordinate) throws DuplicateException {
        if (coordinates.contains(coordinate)) {
            throw new DuplicateException("Duplicate");
        }
        this.coordinates.add(coordinate);
    }

    private void isDuplicate(Coordinate coordinate) {}

}
