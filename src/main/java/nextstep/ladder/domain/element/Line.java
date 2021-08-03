package nextstep.ladder.domain.element;

import nextstep.ladder.domain.strategy.LineCreateStrategy;

import java.util.Objects;

public enum Line {
    LEFT,
    RIGHT,
    NONE;

    public static Line make(LineCreateStrategy lineCreateStrategy) {
        validate(lineCreateStrategy);

        if (lineCreateStrategy.isCreatable()) {
            return RIGHT;
        }

        return NONE;
    }

    public Line makeNext(LineCreateStrategy lineCreateStrategy) {
        if (checkPrevLine()) {
            return LEFT;
        }

        return make(lineCreateStrategy);
    }

    public Line makeEnd() {
        if (checkPrevLine()) {
            return LEFT;
        }

        return NONE;
    }

    private boolean checkPrevLine() {
        return isRight();
    }

    private static void validate(LineCreateStrategy lineCreateStrategy) {
        if (Objects.isNull(lineCreateStrategy)) {
            throw new IllegalArgumentException("LineCreateStrategy는 null이면 안됩니다");
        }
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
