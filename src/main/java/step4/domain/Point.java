package step4.domain;

public class Point {
    private final boolean left;
    private final boolean now;

    public Point(boolean left, boolean now) {
        validateLine(left, now);
        this.left = left;
        this.now = now;
    }

    private static void validateLine(boolean left, boolean now) {
        if (left && now) {
            throw new IllegalArgumentException("연속된 가로줄은 있을 수 없습니다.");
        }
    }

    public static Point first(boolean now) {
        return new Point(false, now);
    }

    public static Point last(boolean now) {
        return new Point(now, false);
    }

    public Direction nextDirection() {
        if (isAbleToMoveLeft()) {
            return Direction.LEFT;
        }
        if (isAbleToMoveRight()) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private boolean isAbleToMoveLeft() {
        return left && !now;
    }

    private boolean isAbleToMoveRight() {
        return !left && now;
    }
}
