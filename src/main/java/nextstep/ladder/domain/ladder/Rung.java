package nextstep.ladder.domain.ladder;

import java.util.Optional;

/**
 * 사다리 발판
 */
public enum Rung {
    LEFT(-1),
    RIGHT(1),
    NONE(0)
    ;

    private final int direction;

    Rung(int direction) {
        this.direction = direction;
    }

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
        return currentIndex.move(direction);
    }
}
