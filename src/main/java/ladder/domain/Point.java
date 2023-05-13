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
