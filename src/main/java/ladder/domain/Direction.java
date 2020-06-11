package ladder.domain;

import java.util.function.Function;

public enum Direction {
    LEFT(index -> index -= 1),
    RIGHT(index -> index += 1),
    DOWN(index -> index);

    private final Function<Integer, Integer> moveIndexByDirection;

    private Direction(Function<Integer, Integer> moveIndexByDirection) {
        this.moveIndexByDirection = moveIndexByDirection;
    }

    public int moveIndexByDirection(int index) {
        return moveIndexByDirection.apply(index);
    }
}
