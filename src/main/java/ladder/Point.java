package ladder;

import java.util.List;
import java.util.Objects;

public class Point {
    private boolean point;
    private Point prevPoint;


    public Point(boolean point) {
        this.point = point;
    }

    public Point(boolean point, Point prevPoint) {
        this(point);
        this.prevPoint = prevPoint;
    }

    public String drawPoint() {
        if (point) {
            return "-----";
        }
        return "     ";
    }

    public boolean isTrue() {
        return this.point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point && Objects.equals(prevPoint, point1.prevPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, prevPoint);
    }

    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
    }
}
