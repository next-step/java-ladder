package nextstep.step2.domain;

import java.util.Map;
import java.util.Objects;

public class Point {
    private final int index;
    private final Map<Direction, Boolean> directions;

    private Point(int index, Map<Direction, Boolean> directions) {
        this.index = index;
        this.directions = directions;
    }

    public static Point createFirst(final PointCreationStrategy strategy) {
        return new Point(0, Map.of(Direction.LEFT, false, Direction.RIGHT, strategy.isCreation()));
    }

    public Point createNext(final PointCreationStrategy strategy) {
        return new Point(this.index + 1, Map.of(Direction.LEFT, this.isRightLine(), Direction.RIGHT, isMovableRight(strategy)));
    }

    public Point createLast() {
        return new Point(this.index + 1, Map.of(Direction.LEFT, this.isRightLine(), Direction.RIGHT, false));
    }

    public boolean isLeftLine() {
        return directions.get(Direction.LEFT);
    }

    public boolean isRightLine() {
        return directions.get(Direction.RIGHT);
    }

    public int move() {
        if (this.isLeftLine()) {
            return Direction.moveLeft(index);
        }

        if (this.isRightLine()) {
            return Direction.moveRight(index);
        }

        return index;
    }

    private boolean isMovableRight(final PointCreationStrategy strategy) {
        if (this.isRightLine()) {
            return false;
        }

        return strategy.isCreation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Point point = (Point) o;
        return index == point.index &&
            Objects.equals(directions, point.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, directions);
    }
}
