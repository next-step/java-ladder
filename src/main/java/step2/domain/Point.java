package step2.domain;

import java.util.Objects;

public class Point {
    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public Point(Point previousPoint) {
        if (previousPoint.point) {
            this.point = false;
            return;
        }
        this.point = new PointRandomStrategy().create();
    }

    public String print() {
        if (point) {
            return "-----|";
        }
        return "     |";
    }


    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
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
