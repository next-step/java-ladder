package nextstep.mission.domain;

import java.util.Objects;

public class Point {
    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public boolean isRight(Point right) {
        if (right == null)
            return false;

        return right.toBoolean();
    }

    public static Point of(boolean point) {
        return new Point(point);
    }

    public boolean toBoolean() {
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
