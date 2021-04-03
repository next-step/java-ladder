package step4_ladderGame.domain;

import java.util.Objects;

public class Point {

    private final boolean prev;
    private final boolean current;

    private Point(boolean prev, boolean current) {
        this.prev = prev;
        this.current = current;
    }

    public static Point of(boolean prev, boolean current) {
        return new Point(prev, current);
    }

    public static Point first(boolean current) {
        return Point.of(false, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return prev == point.prev && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev, current);
    }

    public Point next(boolean next) {
        return Point.of(current, next);
    }

    public Point last() {
        return Point.of(current, false);
    }

    public Direction move() {
        return Direction.valueOf(prev, current);
    }
}

