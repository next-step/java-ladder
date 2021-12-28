package nextstep.ladder.domain;

/**
 * @author han
 */
public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        valid(left, current);
        this.left = left;
        this.current = current;
    }

    public static Point init(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, this.current == true ? false : current);
    }

    public Point end() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (hasLineAfter()) {
            return Direction.RIGHT;
        }

        if (hasLineBefore()) {
            return Direction.LEFT;
        }

        return Direction.PASS;
    }

    public boolean hasLineBefore() {
        return left && !current;
    }

    public boolean hasLineAfter() {
        return !left && current;
    }

    private void valid(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
    }
}
