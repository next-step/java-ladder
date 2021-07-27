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

    public boolean initMiddle(StepGenerateStrategy stepGenerateStrategy) {
        return false;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
