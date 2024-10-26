package ladder;

public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("유효하지 않는 사다리 구성입니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }
}
