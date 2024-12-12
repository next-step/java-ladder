package nextstep.ladder.domain;

import java.util.Arrays;

public enum Direction {
    RIGHT((left, right) -> {
        return !left && right;
    }),

    LEFT((left, right) -> {
        return left && !right;
    }),

    PASS((left, right) -> {
        return !left && !right;
    });

    private final DirectionOperation directionOperation;

    Direction(DirectionOperation directionOperation) {
        this.directionOperation = directionOperation;
    }

    public static Direction of(boolean left, boolean right) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.directionOperation.getDirection(left, right))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public boolean isLeft() {
        return this == Direction.LEFT;
    }

    public boolean isRight() {
        return this == Direction.RIGHT;
    }
}
