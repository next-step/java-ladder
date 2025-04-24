package ladder;

import nextstep.ladder.Direction;

public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("Line은 연속될 수 없습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.SOUTH;
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public boolean isCurrent() {
        return current;
    }

    public boolean isRightDirection() {
        return move() == Direction.RIGHT;
    }
}
