package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public enum Step {
    LEFT,
    RIGHT,
    NONE;

    public static Step init(StepGenerateStrategy stepGenerateStrategy) {
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

    public boolean isRight() {
        return this == RIGHT;
    }
}
