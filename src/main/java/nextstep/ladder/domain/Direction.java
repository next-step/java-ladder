package nextstep.ladder.domain;

import java.util.Arrays;

public enum Direction {
    RIGHT((left, right) -> {
        return !left && right;
    }, 1),

    LEFT((left, right) -> {
        return left && !right;
    }, -1),

    PASS((left, right) -> {
        return !left && !right;
    }, 0);

    private final DirectionOperation directionOperation;
    private final int moveX;

    Direction(DirectionOperation directionOperation, int moveX) {
        this.directionOperation = directionOperation;
        this.moveX = moveX;
    }

    public static Direction of(boolean left, boolean right) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.directionOperation.getDirection(left, right))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int moveX(int curreuntX) {
        return this.moveX + curreuntX;
    }

    public int moveY(int curreuntY) {
        return ++curreuntY;
    }

}

