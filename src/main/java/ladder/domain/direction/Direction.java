package ladder.domain.direction;

public class Direction {

    public static final Direction RIGHT = new Direction(false,  true);
    public static final Direction LEFT  = new Direction(true,   false);
    public static final Direction STAY  = new Direction(false,  false);

    private final boolean left;
    private final boolean right;

    private Direction(boolean isLeft, boolean isRight) {
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
