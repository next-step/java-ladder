package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Directions {
    private final List<Direction> directions;

    public Directions(List<Direction> directions) {
        validateDirectionsContinuity(directions);
        this.directions = directions;
    }

    private void validateDirectionsContinuity(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .filter(index -> isDirectionsDoubleLeft(directions, index))
                .findFirst()
                .ifPresent(i -> {
                    throw new LineDuplicateException();
                });
    }

    private boolean isDirectionsDoubleLeft(List<Direction> directions, int index) {
        return directions.get(index).isLeft() && directions.get(index + 1).isLeft();
    }

    public int move(int position) {
        Direction direction = directions.get(position);
        return direction.plus(position);
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> directions() {
        return Collections.unmodifiableList(directions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directions that = (Directions) o;
        return Objects.equals(directions, that.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}
