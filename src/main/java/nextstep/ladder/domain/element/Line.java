package nextstep.ladder.domain.element;

import nextstep.ladder.domain.play.PlayerPosition;
import nextstep.ladder.domain.strategy.LineCreateStrategy;

import java.util.Objects;
import java.util.function.Function;

public enum Line {
    LEFT(PlayerPosition::moveLeft),
    RIGHT(PlayerPosition::moveRight),
    NONE(position -> position);

    private final Function<PlayerPosition, PlayerPosition> move;

    Line(Function<PlayerPosition, PlayerPosition> move) {
        this.move = move;
    }

    public static Line make(LineCreateStrategy lineCreateStrategy) {
        validate(lineCreateStrategy);

        if (lineCreateStrategy.isCreatable()) {
            return RIGHT;
        }

        return NONE;
    }

    public Line makeNext(LineCreateStrategy lineCreateStrategy) {
        if (isRight()) {
            return LEFT;
        }

        return make(lineCreateStrategy);
    }

    public Line makeEnd() {
        if (isRight()) {
            return LEFT;
        }

        return NONE;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public PlayerPosition move(PlayerPosition position) {
        return move.apply(position);
    }

    private static void validate(LineCreateStrategy lineCreateStrategy) {
        if (Objects.isNull(lineCreateStrategy)) {
            throw new IllegalArgumentException("LineCreateStrategy는 null이면 안됩니다");
        }
    }
}
