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
                .orElse(null);
    }

    public static boolean isLeft(Direction direction) {
        return direction == Direction.LEFT;
    }

    public static boolean isRight(Direction direction) {
        return direction == Direction.RIGHT;
    }
}
