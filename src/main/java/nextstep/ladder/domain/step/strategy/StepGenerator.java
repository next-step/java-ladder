package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Bridge;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

@FunctionalInterface
public interface StepGenerator {
    Step generate(Steps previouSteps, Bridge bridge);
}
