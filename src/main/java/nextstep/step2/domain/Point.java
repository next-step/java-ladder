package nextstep.step2.domain;

import java.util.Objects;

public class Point {

    private final int MOVE_VALUE = 1;

    private final int value;

    private Point(int value) {
        this.value = value;
    }

    public static Point of(int now) {
        return new Point(now);
    }

    public static Point of(Point now) {
        return of(now.value);
    }

    public int getValue() {
        return value;
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
        return value == point1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Point left() {
        return of(this.value - MOVE_VALUE);
    }

    public Point right() {
        return of(this.value + MOVE_VALUE);
    }
}
