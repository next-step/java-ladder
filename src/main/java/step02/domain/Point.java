package step02.domain;

import java.util.Objects;

public class Point {
    private final Boolean hasPoint;

    private Point(Boolean hasPoint) {
        this.hasPoint = hasPoint;
    }

    public static Point of(Boolean hasPoint) {
        return new Point(hasPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(hasPoint, point.hasPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasPoint);
    }
}
