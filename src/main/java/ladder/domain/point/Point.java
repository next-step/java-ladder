package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

public class Point {
    private final int position;
    private final boolean left;
    private final boolean right;

    private Point(int position, boolean left, boolean right) {
        this.position = position;
        this.left = left;
        this.right = right;
    }

    public static Point first(PointStrategy pointStrategy) {
        return new Point(0, false, pointStrategy.next());
    }

    public Point last() {
        return new Point(position + 1, this.right, false);
    }

    public Point next(PointStrategy pointStrategy) {
        return next(this.position + 1, pointStrategy);
    }

    private Point next(int position, PointStrategy pointStrategy) {
        if (this.right) {
            return new Point(position, true, false);
        }
        return new Point(position, false, pointStrategy.next());
    }

    public boolean isLeft() {
        return this.left;
    }

    public int move() {
        if (this.left) {
            return position - 1;
        }

        if (this.right) {
            return position + 1;
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                left == point.left &&
                right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, left, right);
    }
}
