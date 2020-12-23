package nextstep.laddergame.domain;

import java.util.function.Function;

public enum Direction {
    RIGHT(1, (index) -> ++index),
    LEFT(-1, (index) -> --index),
    NOT_MOVE(0, (index) -> index);

    private int direction;
    private final Function<Integer, Integer> function;

    Direction(int direction, Function<Integer, Integer> function) {
        this.direction = direction;
        this.function = function;
    }

    public int moveLine(int index) {
        return this.function.apply(index);
    }

    public boolean isLeft(){
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isNotMove() {
        return this == NOT_MOVE;
    }
}
