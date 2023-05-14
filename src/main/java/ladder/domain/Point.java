package ladder.domain;

import java.util.Objects;

public class Point {
    private static final boolean CONNECTED = true;
    private static final boolean NOT_CONNECTED = false;
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Point(boolean left, boolean right) {
        this.direction = Direction.of(left, right);
    }

    public static Point first(boolean right) {
        return new Point(NOT_CONNECTED, right);
    }

    public Point last() {
        return new Point(direction.isRight(), NOT_CONNECTED);
    }

    public Point next(DrawStrategy drawStrategy) {
        if (direction.isRight()) {
            return new Point(Direction.LEFT);
        }
        if (drawStrategy.draw()) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.NONE);
    }

    public boolean isRight() {
        return direction.isRight();
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
