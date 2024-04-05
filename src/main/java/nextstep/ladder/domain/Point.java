package nextstep.ladder.domain;

import nextstep.ladder.exception.ConsecutivePointException;

import java.util.concurrent.ThreadLocalRandom;

public class Point {

    private final boolean previous;
    private final boolean current;

    public static Point first() {
        return new Point(false, random());
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public static Point last(boolean previous) {
        return Point.from(previous, false);
    }

    public static Point next(boolean previous) {
        return Point.from(previous, random());
    }

    private static Point from(boolean previous, boolean current) {
        if (previous) {
            return new Point(true, false);
        }
        return new Point(false, current);
    }

    public static Point next(boolean previous, boolean current) {
        return new Point(previous, current);
    }
    
    private Point(boolean previous, boolean current) {
        validateConsecutivePoint(previous, current);
        this.previous = previous;
        this.current = current;
    }

    private void validateConsecutivePoint(boolean previous, boolean current) {
        if (previous && current) {
            throw new ConsecutivePointException();
        }
    }

    private static boolean random() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public int move() {
        if (previous) {
            return -1;
        }

        if (current) {
            return 1;
        }

        return 0;
    }

    public boolean current() {
        return current;
    }

}
