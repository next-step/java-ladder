package ladder.domain.ladder;

import static ladder.utils.RandomPointGenerator.*;

import ladder.exception.InvalidPointException;

public class Point {

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point first() {
        return first(generate());
    }

    public Point next(boolean right) {
        return new Point(this.right, right);
    }

    public Point next() {
        if (right) {
            return next(false);
        }
        return next(generate());
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean value() {
        return this.left;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidPointException();
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
