package nextstep.ladder.model;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연속으로 연결할 수 없습니다");
        }

        this.left = left;
        this.right = right;
    }

    public static Point first(boolean value) {
        return new Point(false, value);
    }

    public Point next(boolean value) {
        if (this.right) {
            return new Point(true, false);
        }

        return new Point(false, value);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Direction directionTo() {
        if (this.left) {
            return Direction.LEFT;
        }

        if (this.right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

    public boolean isConnected() {
        return left;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Point point = (Point) other;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
