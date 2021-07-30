package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.ladder.Step;

public class NeverGenerateStrategyTemp implements StepGenerateStrategyTemp {
    public static StepGenerateStrategyTemp NEVER_GENERATE_STRATEGY_TEMP = new NeverGenerateStrategyTemp();

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
