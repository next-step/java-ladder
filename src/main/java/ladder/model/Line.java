package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Direction> directions = new ArrayList<>();
    private final DirectionGenerator directionGenerator;

    public Line(int directionCount, DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
        create(directionCount);
    }

    private void create(int directionCount) {
        Direction direction = Direction.first(directionGenerator.generate());
        directions.add(direction);

        for (int i = 1; i < directionCount - 1; i++) {
            direction = direction.next(directionGenerator.generate());
            directions.add(direction);
        }

        directions.add(direction.last());
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }

    public int size() {
        return directions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(directions, line1.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}
