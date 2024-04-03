package nextstep.ladder.domain;

import java.util.function.Function;

public enum Direction {

    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    STOP(x -> x);

    private final Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int move(int position) {
        return function.apply(position);
    }
}
