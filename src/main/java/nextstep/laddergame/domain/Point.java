package nextstep.laddergame.domain;

import nextstep.laddergame.service.Direction;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public static Point last(Boolean left) {
        return new Point(left, false);
    }

    public Point next(boolean next) {
        return new Point(this.current, next);
    }

    public boolean isSet() {
        return current;
    }

    public Direction resolveMoveDirection() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.SOUTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
