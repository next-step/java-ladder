package ladder.domain.point;

import java.util.Objects;

public class Point {

    private static final Point FIRST = Point.create(0, false);

    private final int index;
    private final boolean movable;

    public Point(int index, boolean movable) {
        this.index = index;
        this.movable = movable;
    }

    public static Point create(int index, boolean movable) {
        return new Point(index, movable);
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
        return index == point.index &&
                movable == point.movable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, movable);
    }
}
