package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public enum Step {
    LEFT,
    RIGHT,
    NONE;

    public static Step generate(StepGenerateStrategy stepGenerateStrategy) {
        return null;
    }
}
