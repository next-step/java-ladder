package nextstep.ladder.ladder;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum MoveType {
    LEFT(-1,(left, right) -> left && !right),
    RIGHT(1,(left, right) -> !left  && right),
    STOP(0,(left, right) -> !left && !right);

    private final int moveValue;
    private final BiPredicate<Boolean, Boolean> predicate;

    MoveType(int moveValue, BiPredicate<Boolean, Boolean> predicate) {
        this.moveValue = moveValue;
        this.predicate = predicate;
    }

    public static MoveType findMatchType(Boolean left, Boolean right) {
        return Arrays.stream(values())
                .filter(type -> type.predicate.test(left, right))
                .findFirst()
                .orElse(STOP);
    }

    public int getMoveValue() {
        return moveValue;
    }
}
