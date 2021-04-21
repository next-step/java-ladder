package ladder;

public final class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("상태 값이 유효하지 않습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static final Point first(boolean current) {
        return new Point(false, current);
    }

    public final Direction move() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }

    public final Point next(boolean current) {
        return new Point(this.current, current);
    }

}
