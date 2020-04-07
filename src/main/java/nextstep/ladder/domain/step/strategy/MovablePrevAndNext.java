package nextstep.ladder.domain.step.strategy;

import nextstep.ladder.domain.step.Row;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class MovablePrevAndNext implements StepGenerator {
    @Override
    public Step generate(Steps previouSteps, int linePosition, int stepPosition) {
        List<Integer> movablePositions = findMovablePositions(previouSteps, linePosition);

        if (movablePositions.contains(stepPosition)) {
            return Step.movablePrev(linePosition, stepPosition, () -> true);
        }
        return Step.movableNext(linePosition, stepPosition, new RandomMovement());
    }

    private List<Integer> findMovablePositions(Steps previouSteps, int currentLinePosition) {
        return previouSteps.getSteps().stream()
                .filter(previousStep -> previousStep.isMovableLine(currentLinePosition))
                .map(Step::getStepPosition)
                .collect(Collectors.toList());
    }
}
