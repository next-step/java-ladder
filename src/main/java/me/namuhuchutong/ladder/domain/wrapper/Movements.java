package me.namuhuchutong.ladder.domain.wrapper;

import java.util.function.Function;

import static me.namuhuchutong.ladder.domain.wrapper.Movements.Constants.*;

public enum Movements {

    MOVE_LEFT(point -> point - MOVE_UNIT),
    MOVE_RIGHT(point -> point + MOVE_UNIT),
    STOP(point -> point);

    private final Function<Integer, Integer> calculateMove;

    Movements(Function<Integer, Integer> calculateMove) {
        this.calculateMove = calculateMove;
    }

    public int move(int currentPoint) {
        return this.calculateMove.apply(currentPoint);
    }

    static class Constants {
        static final int MOVE_UNIT = 2;
    }
}
