package nextstep.ladder.domain;

/**
 * @author han
 */
public class Point {
    private static final int FORWARD = 1;
    private static final int BACKWARD = -1;
    private static final int PASS = 0;

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
        return new Point(this.current, current);
    }

    public Point end() {
        return new Point(this.current, false);
    }

    public int move() {
        if (hasLineAfter()) {
            return FORWARD;
        }

        if (hasLineBefore()) {
            return BACKWARD;
        }

        return PASS;
    }

    public boolean isCurrent() {
        return current;
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
