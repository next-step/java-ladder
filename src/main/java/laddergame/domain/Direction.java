package laddergame.domain;

import java.util.Random;

import static java.lang.Boolean.FALSE;

public class Direction {

    private static final Random RANDOM = new Random();

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;

    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(RANDOM.nextBoolean());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first() {
        return of(FALSE, RANDOM.nextBoolean());
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

}
