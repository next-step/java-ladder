package nextstep.ladder.domain.ladder;

import java.util.function.Function;

public enum Direction {
    LEFT((distance) -> -distance),
    RIGHT((distance) -> distance),
    PASS((distance) -> 0);
    private Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int move(int distance) {
        return function.apply(distance);
    }
}
