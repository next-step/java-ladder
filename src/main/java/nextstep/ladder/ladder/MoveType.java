package nextstep.ladder.ladder;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum MoveType {
    LEFT((left, right) -> left && !right),
    RIGHT((left, right) -> !left  && right),
    NEXT((left, right) -> !left && !right);

    private final BiPredicate<Boolean, Boolean> predicate;

    MoveType(BiPredicate<Boolean, Boolean> predicate) {
        this.predicate = predicate;
    }

    public static MoveType findMatchType(Boolean left, Boolean right) {
        return Arrays.stream(values())
                .filter(type -> type.predicate.test(left, right))
                .findFirst()
                .orElse(NEXT);
    }
}
