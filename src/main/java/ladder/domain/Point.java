package ladder.domain;

public class Point {

    private final boolean prior;
    private final boolean current;

    private Point(boolean prior, boolean current) {
        if (prior && current) {
            throw new IllegalArgumentException("상태값이 유효하지 않습니다.");
        }

        this.prior = prior;
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

    public boolean getCurrent() {
        return current;
    }

    public Direction selectDirection() {
        if (prior) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }
}
