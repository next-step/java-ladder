package ladder.domain.point;

import java.util.Objects;

public class Point {

    private static final Point FIRST = Point.create(false);

    private final boolean movable;

    public Point(boolean movable) {
        this.movable = movable;
    }

    public static Point create(boolean movable) {
        return new Point(movable);
    }

    public static Point first() {
        return FIRST;
    }

    public boolean isMovable() {
        return movable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return movable == point.movable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movable);
    }
}
