package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.strategy.DirectionStrategy;

import java.util.Objects;

public enum Direction {
    LEFT,
    RIGHT,
    SOUTH;

    public static Direction createFirst(final DirectionStrategy generator) {
        return Objects.requireNonNull(generator).isPossible() ? RIGHT : SOUTH;
    }

    public Direction createNext(final DirectionStrategy generator) {
        return isRight() ? LEFT : createFirst(generator);
    }

    public Direction createLast() {
        return isRight() ? LEFT : SOUTH;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
