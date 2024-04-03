package nextstep.ladder.domain;

import nextstep.ladder.exception.ConsecutivePointException;

import java.util.concurrent.ThreadLocalRandom;

public class Point {

    private final boolean left;
    private final boolean right;

    public static Point first() {
        return new Point(false, random());
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public static Point last(boolean left) {
        return Point.from(left, false);
    }

    public static Point next(boolean left) {
        return Point.from(left, random());
    }

    private static Point from(boolean left, boolean right) {
        if (left) {
            return new Point(true, false);
        }
        return new Point(false, right);
    }

    public static Point next(boolean left, boolean right) {
        return new Point(left, right);
    }
    
    private Point(boolean left, boolean right) {
        validateConsecutivePoint(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateConsecutivePoint(boolean left, boolean right) {
        if (left && right) {
            throw new ConsecutivePointException();
        }
    }

    private static boolean random() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public Direction getDirection() {
        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.STOP;
    }

    public boolean right() {
        return right;
    }

}
