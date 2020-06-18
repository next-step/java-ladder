package ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(index -> index -= Point.NEXT_INDEX),
    RIGHT(index -> index += Point.NEXT_INDEX),
    DOWN(index -> index);

    private final UnaryOperator<Integer> moveIndexByDirection;

    private Direction(UnaryOperator<Integer> moveIndexByDirection) {
        this.moveIndexByDirection = moveIndexByDirection;
    }

    public static Direction first(boolean isDown) {
        return isDown ? DOWN : RIGHT;
    }

    public Direction last() {
        return this == RIGHT ? LEFT : DOWN;
    }

    public Direction next(boolean isDown) {
        if (this == RIGHT) {
            return LEFT;
        }
        return isDown ? DOWN : RIGHT;
    }

    public int moveIndexByDirection(int index) {
        return this.moveIndexByDirection.apply(index);
    }
}
