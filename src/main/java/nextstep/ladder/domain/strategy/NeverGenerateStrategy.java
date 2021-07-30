package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.ladder.Step;

public class NeverGenerateStrategy implements StepGenerateStrategy {
    public static StepGenerateStrategy NEVER_GENERATE_STRATEGY = new NeverGenerateStrategy();

    @Override
    public Step generateFirst() {
        return Step.NONE;
    }

    @Override
    public Step generateMiddle(Step prevStep) {
        if (prevStep.isRight()) {
            return Step.LEFT;
        }

        return Step.NONE;
    }

    @Override
    public Step generateLast(Step prevStep) {
        if (prevStep.isRight()) {
            return Step.LEFT;
        }

        return Step.NONE;
    }
}
