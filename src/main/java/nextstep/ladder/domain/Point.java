package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int DOWN = 0;

    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("유효하지 않은 상태입니다.");
        }
        this.left = left;
        this.right = right;
    }

    public Point() {
        this(false, false);
    }

    public Point next(boolean next) {
        return new Point(this.right, next);
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point last(boolean left) {
        return new Point(left, false);
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public boolean isRightConnected() {
        return right;
    }

    public int getDirection() {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return DOWN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
