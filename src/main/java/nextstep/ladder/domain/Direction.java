package nextstep.ladder.domain;

import java.util.function.Function;

public enum Direction {

    LEFT(point -> point - 1),
    CENTER(point -> point),
    RIGHT(point -> point + 1);

    private final Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int nextPoint(int point) {
        return this.function.apply(point);
    }
}
