package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.ladder.Step;

public interface StepGenerateStrategy {
    Step generateFirst();
    Step generateMiddle(Step prevStep);
    Step generateLast(Step prevStep);
}
