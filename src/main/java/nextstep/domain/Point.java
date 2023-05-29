package nextstep.domain;

public class Point {

    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 라인은 연속적으로 존재할 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(right, current);
    }

    public Point last() {
        return new Point(right, false);
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

    public boolean isRight() {
        return right;
    }
}
