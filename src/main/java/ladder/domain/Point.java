package ladder.domain;

import java.util.Objects;

public class Point {
    private boolean left;
    private boolean right;

    private Point(boolean left, boolean right) {
        if (left == true && right == true) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
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

    public int nextDirection() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }

    public boolean canMoveRight() {
        return right;
    }

    public boolean isOverlap(Point previousPoint) {
        return right && previousPoint.right;
    }
}
