package step2.model;

import java.util.Objects;

public class Point {
    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean getPoint() {
        return point;
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
