package ladder.domain;

import java.util.Objects;

public class Point {

    private static final boolean NON_LINE = false;
    private final boolean point;

    public Point() {
        this.point = NON_LINE;
    }

    public Point(boolean isLine) {
        this.point = isLine;
    }

    public boolean isPoint() {
        return point;
    }

    public boolean isValidate(boolean isLine) {
        return !point || !isLine;
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
