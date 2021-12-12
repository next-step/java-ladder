package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if (left && current) {
            current = false;
        }

        this.left = left;
        this.current = current;
    }

    public static Point firstPoint(boolean current) {
        return new Point(false, current);
    }

    public static Point lastPoint(boolean left) {
        return new Point(left, false);
    }

    public boolean getCurrent() {
        return current;
    }

    public String getResultPoint() {
        if (current) {
            return "-----";
        }
        return "     ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left &&
                current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

}
