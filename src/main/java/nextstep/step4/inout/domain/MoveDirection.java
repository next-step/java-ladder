package nextstep.step4.inout.domain;

import java.util.function.IntFunction;

public enum MoveDirection {
    LEFT(idx -> idx - 1),
    NONE(idx -> idx),
    RIGHT(idx -> idx + 1);

    private final IntFunction<Integer> moveStrategy;

    MoveDirection(final IntFunction<Integer> moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int move(int index) {
        return moveStrategy.apply(index);
    }
}
