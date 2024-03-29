package nextstep.step4.model;

import java.util.function.Function;

public enum Direction {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    DOWN(x -> x);

    private Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int move(int position) {
        return this.function.apply(position);
    }
}
