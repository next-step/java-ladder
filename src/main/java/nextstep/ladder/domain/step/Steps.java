package nextstep.ladder.domain.step;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.step.strategy.RandomMovement;
import nextstep.ladder.domain.step.strategy.StepGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Steps {
    private static final int ONE = 1;

    private final List<Step> steps;
    private final Position linePosition;

    private Steps(List<Step> steps, int linePosition) {
        this.steps = Collections.unmodifiableList(steps);
        this.linePosition = new Position(linePosition);
    }

    public static Steps movableNext(int height, int linePosition) {
        List<Step> steps = new ArrayList<>();
        for (int stepPosition = 0; stepPosition < height; stepPosition++) {
            steps.add(Step.of(Row.next(linePosition, stepPosition), new RandomMovement()));
        }
        return new Steps(steps, linePosition);
    }

    public static Steps movableByPreviousCondition(Steps previousSteps, StepGenerator stepGenerator) {
        int height = previousSteps.getLineHeight();
        int currentLinePosition = previousSteps.nextLinePosition();
        List<Step> steps = new ArrayList<>();
        for (int stepPosition = 0; stepPosition < height; stepPosition++) {
            steps.add(stepGenerator.generate(previousSteps, Row.current(currentLinePosition, stepPosition)));
        }
        return new Steps(steps, currentLinePosition);
    }

    private int getLineHeight() {
        return steps.size();
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Step get(int index) {
        return steps.get(index);
    }

    public int getLinePosition() {
        return linePosition.getPosition();
    }

    private int nextLinePosition() {
        return linePosition.getPosition() + ONE;
    }
}
