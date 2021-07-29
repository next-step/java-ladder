package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;
import java.util.function.Function;

public enum Step {
    LEFT(LadderPosition::moveLeft),
    RIGHT(LadderPosition::moveRight),
    NONE(prevPosition -> prevPosition);

    private final Function<LadderPosition, LadderPosition> determinant;

    Step(Function<LadderPosition, LadderPosition> determinant) {
        this.determinant = determinant;
    }


    public static Step init(StepGenerateStrategy stepGenerateStrategy) {
        validate(stepGenerateStrategy);

        if (stepGenerateStrategy.isGenerable()) {
            return RIGHT;
        }

        return NONE;
    }

    public Step initNext(StepGenerateStrategy stepGenerateStrategy) {
        if (isRight()) {
            return LEFT;
        }

        return init(stepGenerateStrategy);
    }

    public Step initLast() {
        if (isRight()) {
            return LEFT;
        }

        return NONE;
    }

    private static void validate(StepGenerateStrategy stepGenerateStrategy) {
        if (Objects.isNull(stepGenerateStrategy)) {
            throw new NullArgumentException(StepGenerateStrategy.class);
        }
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public LadderPosition move(LadderPosition ladderPosition) {
        return determinant.apply(ladderPosition);
    }
}
