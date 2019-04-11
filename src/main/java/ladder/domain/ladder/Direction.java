package ladder.domain.ladder;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);

        this.left = left;
        this.right = right;
    }

    static Direction first(boolean right) {
        return new Direction(Boolean.FALSE, right);
    }

    Direction last() {
        return next(Boolean.FALSE);
    }

    Direction next(boolean right) {
        return new Direction(this.right, right);
    }

    boolean isLeft() {
        return this.left;
    }

    boolean isRight() {
        return this.right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("You can't cross both ways");
        }
    }
}
