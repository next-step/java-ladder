package ladder.domain;

import java.util.Objects;

public class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Point(boolean left, boolean right) {
        this.direction = Direction.of(left, right);
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public Point next(boolean nextRight) {
        if (direction.isRight()) {
            return new Point(true, false);
        }
        return new Point(false, nextRight);
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
