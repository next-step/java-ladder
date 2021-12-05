package step2.domain;

import java.util.function.Consumer;

public enum Direction {
    LEFT(Position::moveBack),
    RIGHT(Position::moveFront),
    NONE(Position::position);

    private final Consumer<Position> moveResult;

    Direction(Consumer<Position> moveResult) {
        this.moveResult = moveResult;
    }

    public static Direction findBy(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return NONE;
    }

    public void move(Position position) {
        moveResult.accept(position);
    }
}
