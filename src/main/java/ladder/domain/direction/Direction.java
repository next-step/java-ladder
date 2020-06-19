package ladder.domain.direction;

import java.util.function.Function;

public enum Direction {

    RIGHT (false, true,   position -> position + 1),
    LEFT  (true,  false,  position -> position - 1),
    STAY  (false, false,  position -> position);

    private final boolean left;
    private final boolean right;
    private final Function<Integer, Integer> moveExpression;

    Direction(boolean left, boolean right, Function<Integer, Integer> moveExpression) {
        this.left = left;
        this.right = right;
        this.moveExpression = moveExpression;
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

    public int pass(int position) {
        return moveExpression.apply(position);
    }
}
