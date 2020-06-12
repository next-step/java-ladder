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

    public int moveIndexByDirection(int index) {
        return this.moveIndexByDirection.apply(index);
    }
}
