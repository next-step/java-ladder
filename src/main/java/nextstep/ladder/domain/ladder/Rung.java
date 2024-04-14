package nextstep.ladder.domain.ladder;

import java.util.Optional;

public enum Rung {
    LEFT,
    RIGHT,
    NONE
    ;

    public static Rung from(boolean addable) {
        if (addable) {
            return RIGHT;
        }
        return NONE;
    }

    public Rung generate(RungGenerateStrategy generateStrategy) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> {
                    if (notConnected() || isLeft()) {
                        return from(generateStrategy.addable());
                    }
                    return LEFT;
                })
                .orElse(NONE);
    }

    public Rung generateLast() {
        if (isRight()) {
            return LEFT;
        }
        return NONE;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean notConnected() {
        return this == NONE;
    }

    public ColumnIndex nextColumnIndex(ColumnIndex currentIndex) {
        if (this == LEFT) {
            return currentIndex.before();
        }

        if (this == RIGHT) {
            return currentIndex.next();
        }

        return currentIndex;
    }
}
