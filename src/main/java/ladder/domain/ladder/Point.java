package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

public class Point {

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("true 값은 연속해서 위치할 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Point first(LineStrategy lineStrategy) {
        return new Point(false, lineStrategy.isConnectable());
    }

    public Point next(LineStrategy lineStrategy) {
        if (right) {
            return new Point(right, false);
        }
        return new Point(right, lineStrategy.isConnectable());
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean left() {
        return left;
    }

    public boolean right() {
        return right;
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }

        return Direction.SOUTH;
    }

}
