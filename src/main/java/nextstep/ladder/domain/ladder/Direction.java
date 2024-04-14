package nextstep.ladder.domain.ladder;

import java.util.Optional;

public enum Direction {
    LEFT,
    RIGHT,
    NONE
    ;

    public static Direction from(boolean addable) {
        if (addable) {
            return RIGHT;
        }
        return NONE;
    }

    public Direction generate(RungGenerateStrategy generateStrategy) {
        return Optional.ofNullable(generateStrategy)
                .map(strategy -> {
                    if (notConnected() || isLeft()) {
                        return from(generateStrategy.addable());
                    }
                    return LEFT;
                })
                .orElse(NONE);
    }

    public Direction generateLast() {
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
