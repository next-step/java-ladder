package ladder.domain;

public class Point {
    private final boolean prev;
    private final boolean current;

    private Point(boolean prev, boolean current) {
        if (prev && current) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }

        this.prev = prev;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (prev) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.SOUTH;
    }

    public boolean getCurrent() {
        return current;
    }
}
