package ladder.domain.enums;

import ladder.domain.result.Position;

import java.util.Arrays;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    PASS(false, false);

    private boolean left;
    private boolean current;

    Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return Arrays.stream(Direction.values())
            .filter(direction -> direction.left == left && direction.current == current)
            .findFirst().get();
    }

    public Position move(Position position) {
        if (this == LEFT) {
            return position.goLeft();
        }

        if (this == RIGHT) {
            return position.goRight();
        }

        return position;
    }
}
