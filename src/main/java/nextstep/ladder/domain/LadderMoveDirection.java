package nextstep.ladder.domain;

import java.util.function.IntFunction;

public enum LadderMoveDirection {
    LEFT(idx -> idx - 1),
    CENTER(idx -> idx),
    RIGHT(idx -> idx + 1);

    private final IntFunction<Integer> moveStrategy;

    LadderMoveDirection(IntFunction<Integer> moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int move(int idx) {
        return moveStrategy.apply(idx);
    }
}
