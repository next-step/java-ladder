package ladder.domain;

public class Point {
    private final boolean prev;
    private final boolean current;

    private Point(boolean prev, boolean current) {
        validate(prev, current);
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

    private void validate(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("양 방향이 true 일 수 없습니다.");
        }
    }

    public Direction move() {
        if (prev) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.STAY;
    }

    public boolean getCurrent() {
        return current;
    }

    public boolean canDrawNext() {
        return !current;
    }
}
