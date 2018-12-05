package ladder.domain;

import ladder.strategy.Difficulty;
import ladder.utils.StringUtils;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction create(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isNone() {
        return !left && !right;
    }

    public static Direction first(boolean right) {
        return create(false, right);
    }

    public Direction next(boolean nextRight) {
        return create(this.right, nextRight);
    }

    public Direction next(Difficulty difficulty) {
        if (this.right) {
            return next(false);
        }
        return next(difficulty.generate());
    }

    public Direction last() {
        return create(this.right, false);
    }

    @Override
    public String toString() {
        return StringUtils.direction(this);
    }
}
