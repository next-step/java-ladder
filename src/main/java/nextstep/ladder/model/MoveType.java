package nextstep.ladder.model;

import java.util.function.Function;

public enum MoveType {
    NEXT(startIdx -> startIdx + 1),
    BACK(startIdx -> startIdx - 1),
    STAY(startIdx -> startIdx),
    ;

    private Function<Integer, Integer> function;

    MoveType(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int getNextMove(int startIdx) {
        return function.apply(startIdx);
    }
}
