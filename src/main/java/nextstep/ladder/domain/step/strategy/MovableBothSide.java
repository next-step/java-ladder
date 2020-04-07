package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Row;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class MovableBothSide implements StepGenerator {
    @Override
    public Step generate(Steps previouSteps, Row row) {
        List<Integer> movablePositions = findMovableNextPositions(previouSteps);

        if (movablePositions.contains(row.getStepPosition())) {
            return Step.of(Row.next(row), new RandomMovement());
        }
        return Step.of(Row.previous(row), () -> true);
    }

    private List<Integer> findMovableNextPositions(Steps previouSteps) {
        return previouSteps.getSteps().stream()
                .filter(previousStep -> previousStep.isMovableNext(previouSteps.getLinePosition()))
                .map(Step::getPosition)
                .collect(Collectors.toList());
    }
}
