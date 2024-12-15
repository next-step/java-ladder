package nextstep.ladder;

public class Point {
    private boolean current;
    private boolean right;

    public Point(boolean current, boolean right) {
        if (current && right) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
        this.current = current;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean right) {
        if (this.right) {
            return new Point(this.right, false);
        }
        return new Point(this.right, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Direction move() {
        if (current) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}
