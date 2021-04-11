package ladder.domain;

import java.util.Objects;

public class Point {
    private final int index;
    private final boolean point;

    private Point(final int index, final boolean point) {
        this.index = index;
        this.point = point;
    }

    public static Point from(final int index, final boolean point) {
        return new Point(index, point);
    }

    public int move() {
        return point ? index + 1 : index;
    }

    public int move(final boolean beforePoint) {
        if (point) {
            return index + 1;
        }
        if (beforePoint) {
            return index - 1;
        }
        return index;
    }

    public boolean getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return index == point1.index && point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, point);
    }
}
