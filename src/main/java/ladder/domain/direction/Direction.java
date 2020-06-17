package ladder.domain.direction;

public enum Direction {

    RIGHT (false, true),
    LEFT  (true,  false),
    STAY  (false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean isLeft, boolean isRight) {
        this.left = isLeft;
        this.right = isRight;
    }

    public static Direction first(boolean isRight) {
        return isRight ? RIGHT : STAY;
    }

    public static Direction last(boolean isLeft) {
        return isLeft ? LEFT : STAY;
    }

    public Direction next(boolean isNextRight) {
        if (this.right) {
            return LEFT;
        }

        return isNextRight ? RIGHT : STAY;
    }
}
