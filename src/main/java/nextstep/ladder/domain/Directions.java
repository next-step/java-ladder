package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Directions {
    private final List<Direction> directions;

    public Directions(List<Direction> directions) {
        this.directions = directions;
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
