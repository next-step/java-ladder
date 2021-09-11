package step2.domain;

import java.util.Objects;

public class Point {
    private final boolean point;

    public Point(PointStrategy pointStrategy) {
        this(pointStrategy.create());
    }

    public Point() {
        this(false);
    }

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isTrue() {
        return point == true;
    }

    @Override
    public String toString() {
        if (point) {
            return "-----|";
        }
        return "     |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
