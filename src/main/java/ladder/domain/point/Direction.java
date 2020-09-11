package ladder.domain.point;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    DOWN(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    static Direction first(boolean isRight) {
        return isRight ? RIGHT : DOWN;
    }

    Direction next(boolean isNext) {
        if (this.right) {
            return LEFT;
        }

        return isNext ? RIGHT : DOWN;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
