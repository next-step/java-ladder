package ladder.domain.ladder;

import java.util.Objects;

public final class Point {

    private final boolean point;

    public static final Point of(boolean point) {
        return new Point(point);
    }

    private Point(boolean point) {
        this.point = point;
    }

    public static final Point first() {
        return new Point(Boolean.FALSE);
    }

    public final boolean hasPoint() {
        return point == Boolean.TRUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
