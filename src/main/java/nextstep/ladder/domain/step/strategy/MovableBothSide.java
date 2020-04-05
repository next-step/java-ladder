package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Bridge;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class MovableBothSide implements StepGenerator {

    @Override
    public Step generate(Steps previouSteps, Bridge bridge) {
        List<Integer> movablePositions = previouSteps.getSteps().stream()
                .filter(previousStep -> previousStep.isMovableNext(previouSteps.getLinePosition()))
                .map(Step::getPosition)
                .collect(Collectors.toList());

        if (movablePositions.contains(bridge.getStepPosition())) {
            return Step.of(Bridge.next(bridge), new RandomMovement());
        }
        return Step.of(Bridge.previous(bridge), () -> true);
    }
}
