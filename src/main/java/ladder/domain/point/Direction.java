package ladder.domain.point;

import utils.RandomUtils;

import java.util.function.IntUnaryOperator;

public enum Direction {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    NONE(x -> x);

    private final IntUnaryOperator directionPolicy;

    public boolean isRight() {
        return this == RIGHT;
    }

    public static Direction generate() {
        if (RandomUtils.getBoolean()) {
            return RIGHT;
        }

        return NONE;
    }

    public Direction next() {
        if (isRight()) {
            return Direction.LEFT;
        }

        return Direction.generate();
    }

    public Direction nextLast() {
        if (isRight()) {
            return Direction.LEFT;
        }

        return Direction.NONE;
    }

    Direction(IntUnaryOperator directionPolicy) {
        this.directionPolicy = directionPolicy;
    }

    public int move(int position) {
        return directionPolicy.applyAsInt(position);
    }
}
