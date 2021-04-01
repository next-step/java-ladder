package ladder.domain;

import java.util.Objects;

public class Point {

    private static final int RIGHT = 1;
    private static final int LEFT = - 1;
    private static final int STAY = 0;
    private static final boolean NON_LINE = false;
    private final boolean left;
    private final boolean point;

    public Point() {
        this.left = NON_LINE;
        this.point = NON_LINE;
    }
    public Point(boolean isLine) {
        this.left = NON_LINE;
        this.point = isLine;
    }

    public Point(boolean left, boolean isLine) {
        this.left = left;
        this.point = isLine;
    }

    public boolean isPoint() {
        return point;
    }

    public boolean isValidate(boolean isLine) {
        return !point || !isLine;
    }

    public int direction() {
        if (point) {
            return RIGHT;
        }
        if (left) {
            return LEFT;
        }
        return STAY;
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
