package step2;

import java.util.Objects;

public class Point {
    private static final boolean LEFT = false;
    private static final boolean RIGHT = true;

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean currentPoint() {
        return point;
    }

    public boolean move(boolean currentPoint) {
        if (currentPoint) {
            return RIGHT;
        }
        return LEFT;
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
