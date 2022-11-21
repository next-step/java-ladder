package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public static Point first(DirectionStrategy strategy) {
        if (strategy.isRight()) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.LEFT);
    }

    public static Point next(Point previous, DirectionStrategy strategy) {
        if (previous.direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        if (strategy.isRight()) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.LEFT);
    }

    public static Point last(Point previous, DirectionStrategy strategy) {
        if (previous.direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        return new Point(Direction.LEFT);
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
