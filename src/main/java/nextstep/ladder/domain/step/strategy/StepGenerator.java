package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Row;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

@FunctionalInterface
public interface StepGenerator {
    //Step generate(Steps previouSteps, Row row);
    Step generate(Steps previouSteps, int currentLinePosition, int stepPosition);
}
