package nextstep.step2.domain;

import java.util.Objects;

public class Point {

    private final int MOVE_VALUE = 1;

    private final int point;

    private Point(int point) {
        this.point = point;
    }

    public static Point of(int now) {
        return new Point(now);
    }

    public static Point of(Point now) {
        return of(now.point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    public Point left() {
        return of(this.point - MOVE_VALUE);
    }

    public Point right() {
        return of(this.point + MOVE_VALUE);
    }
}
