package nextstep.ladder.model;

import java.util.function.Function;

public enum Direction {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    DOWN(x -> x);

    private Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int next(int position) {
        return function.apply(position);
    }
}
