package nextstep.ladder.domain;

import java.util.Arrays;

public enum Direction {
    LEFT(-1),
    FORWARD(0),
    RIGHT(+1);

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private int move;

    Direction(int move) {
        this.move = move;
    }

    public static Direction from(int move) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getMove() == move)
                .findFirst()
                .get();
    }

    public static Direction decideDirection(Direction direction, int condition, DirectionStrategy directionStrategy) {
        if(condition == ZERO) {
            return directionStrategy.getStartDirection();
        }

        if(condition == -ONE) {
            return directionStrategy.getEndDirection(direction);
        }

        return directionStrategy.getNextDirection(direction);

    }

    public int getMove() {
        return move;
    }
}
