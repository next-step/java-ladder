package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum PositionChange {
    LEFT((canMoveLeft, canMoveRight) -> canMoveLeft, -1),
    RIGHT((canMoveLeft, canMoveRight) -> canMoveRight, 1),
    STAY((canMoveLeft, canMoveRight) -> false, 0);

    private final BiFunction<Boolean, Boolean, Boolean> matchFunction;
    private final int moveAmount;

    PositionChange(BiFunction<Boolean, Boolean, Boolean> matchFunction, int moveAmount) {
        this.matchFunction = matchFunction;
        this.moveAmount = moveAmount;
    }

    public static PositionChange of(boolean canMoveLeft, boolean canMoveRight) {
        return Arrays.stream(PositionChange.values())
                .filter(positionChange -> positionChange.matchFunction.apply(canMoveLeft, canMoveRight))
                .findFirst()
                .orElse(PositionChange.STAY);
    }

    public int getMoveAmount() {
        return this.moveAmount;
    }
}
