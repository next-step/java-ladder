package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Random;

public enum Direction {
    LEFT(-1),
    FORWARD(0),
    RIGHT(+1);

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

    public int getMove() {
        return move;
    }
}
