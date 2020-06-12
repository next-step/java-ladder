package ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(index -> index -= 1),
    RIGHT(index -> index += 1),
    DOWN(index -> index);

    private final UnaryOperator<Integer> moveIndexByDirection;

    private Direction(UnaryOperator<Integer> moveIndexByDirection) {
        this.moveIndexByDirection = moveIndexByDirection;
    }

    public static Direction valueOf(int index) {
        return values()[index];
    }

    public int moveIndexByDirection(int index) {
        return this.moveIndexByDirection.apply(index);
    }

    public String getName() {
        if (this == LEFT) {
            return "LEFT";
        } else if (this == RIGHT) {
            return "RIGHT";
        }
        return "STOP";
    }
}
