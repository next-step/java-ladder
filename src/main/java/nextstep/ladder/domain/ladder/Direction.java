package nextstep.ladder.domain.ladder;

import java.util.function.Function;

import static nextstep.ladder.domain.ladder.LadderPointGenerator.generatePoint;

public enum Direction {
    LEFT("┤", x -> x - 1),
    RIGHT("├", x -> x + 1),
    NONE("┃", x -> x);

    private final String shape;
    private final Function<Integer, Integer> move;

    Direction(String shape, Function<Integer, Integer> move) {
        this.shape = shape;
        this.move = move;
    }

    public static Direction first(boolean right) {
        if (right) {
            return RIGHT;
        }
        return NONE;
    }

    public Direction next() {
        if (this == RIGHT) {
            return LEFT;
        }
        return nextNotHaveLeft(generatePoint());
    }

    private Direction nextNotHaveLeft(boolean nextRight) {
        return nextRight ? RIGHT : NONE;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return NONE;
    }

    public String getShape() {
        return shape;
    }

    public Function<Integer, Integer> getMove() {
        return move;
    }
}
