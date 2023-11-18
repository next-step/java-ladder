package nextstep.ladder.domain;

import java.util.function.Function;

public enum Direction {
    RIGHT("오른쪽으로 이동", point -> point + Constants.DEFAULT_MOVE_UNIT),
    LEFT("왼쪽으로 이동", point -> point - Constants.DEFAULT_MOVE_UNIT),
    STAY("멈춤", point -> point);

    private final String description;
    private final Function<Integer, Integer> move;

    Direction(String description,
              Function<Integer, Integer> move) {
        this.description = description;
        this.move = move;
    }

    public int move(int startPoint) {
        return this.move.apply(startPoint);
    }

    private static class Constants {
        public static final int DEFAULT_MOVE_UNIT = 1;
    }
}
