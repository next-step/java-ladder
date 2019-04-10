package ladder.domain;

public class Direction {
    private final static Direction[] cache = new Direction[3];

    private final boolean left;
    private final boolean right;

    static {
        cache[0] = new Direction(false, false);
        cache[1] = new Direction(false, true);
        cache[2] = new Direction(true, false);
    }

    private Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    static Direction of(final boolean left, final boolean right) {
        validate(left, right);
        return cache[getCacheIndex(left, right)];
    }

    static Direction first(final boolean right) {
        return of(false, right);
    }

    static Direction last(final boolean left) {
        return of(left, false);
    }

    boolean isLeft() {
        return left;
    }

    boolean isRight() {
        return right;
    }

    private static void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    private static int getCacheIndex(final boolean left, final boolean right) {
        return toInt(left) * 2 + toInt(right);
    }

    private static int toInt(final boolean bool) {
        if (bool) {
            return 1;
        }
        return 0;
    }
}
