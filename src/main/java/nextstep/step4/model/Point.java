package nextstep.step4.model;

import java.util.Objects;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static nextstep.step4.model.Direction.DOWN;
import static nextstep.step4.model.Direction.LEFT;
import static nextstep.step4.model.Direction.RIGHT;

public class Point {
    private static final Random RANDOM = new Random();
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("모두 true인 경우는 허용하지 않습니다");
        }

        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(FALSE, right);
    }

    public static Point first() {
        return new Point(FALSE, RANDOM.nextBoolean());
    }

    public Point next() {
        if (this.right) {
            return next(false);
        }

        return next(RANDOM.nextBoolean());
    }

    public Point next(boolean right) {
        return new Point(this.right, right);
    }

    public Point last() {
        return new Point(this.right, FALSE);
    }

    public Direction move() {
        if (this.left) {
            return LEFT;
        }

        if (this.right) {
            return RIGHT;
        }

        return DOWN;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Point point = (Point) other;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
