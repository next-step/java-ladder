package ladder.domain;

import ladder.exception.ContinuousConnectionException;
import ladder.generator.PointGenerator;

import java.util.Objects;

public class Point {

    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;

    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        if (left && right) {
            throw new ContinuousConnectionException();
        }
        this.left = left;
        this.right = right;
    }

    public static Point of(boolean left, boolean right) {
        return new Point(left, right);
    }

    public static Point first(boolean right) {
        return of(DISCONNECTED, right);
    }

    public Point nextRandom() {
        if (this.right) {
            return next(DISCONNECTED);
        }
        return next(PointGenerator.generate());
    }

    public Point next(boolean right) {
        return of(this.right, right);
    }

    public Point last() {
        return of(this.right, DISCONNECTED);
    }

    public boolean isLeftConnected() {
        return left;
    }

    public boolean isRightConnected() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
