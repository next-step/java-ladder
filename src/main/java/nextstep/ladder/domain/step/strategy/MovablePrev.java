package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Row;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class MovablePrev implements StepGenerator {
    @Override
    public Step generate(Steps previouSteps, Row row) {
        List<Integer> movablePositions = findMovablePrevPositions(previouSteps);

        if (movablePositions.contains(row.getStepPosition())) {
            return Step.of(Row.previous(row), () -> true);
        }
        return Step.of(row, () -> false);
    }

    private List<Integer> findMovablePrevPositions(Steps previouSteps) {
        return previouSteps.getSteps().stream()
                .filter(previousStep -> previousStep.isMovablePrev(previouSteps.getLinePosition()))
                .map(Step::getPosition)
                .collect(Collectors.toList());
    }
}
