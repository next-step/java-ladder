package domain;

import generator.PointGenerator;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public Point next(PointGenerator pointGenerator) {
        return Point.of(this.right, pointGenerator.next(this.right));
    }

    public static Point first(boolean right) {
        return of(false, right);
    }

    public Point last() {
        return of(this.right, false);
    }

    public boolean isRight() {
        return this.right;
    }

    public int move(int index) {
        if (right) {
            ++index;
        }

        if (left) {
            --index;
        }

        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
