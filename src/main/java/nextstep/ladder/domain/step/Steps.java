package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.RandomMovement;

import java.util.ArrayList;
import java.util.List;

public class Steps {
    private List<Step> steps;
    private int linePosition;

    public Steps(List<Step> steps, int linePosition) {
        this.steps = steps;
        this.linePosition = linePosition;
    }

    public static Steps firstLineSteps(int height, int linePosition) {
        List<Step> steps = new ArrayList<>();
        for (int stepPosition = 0; stepPosition < height; stepPosition++) {
            steps.add(new Step(linePosition, stepPosition, new RandomMovement()));
        }
        return new Steps(steps, linePosition);
    }

    public static Steps middleLineSteps(Steps previousSteps) {
        List<Step> steps = new ArrayList<>();
        int linePosition = previousSteps.linePosition + 1;

        for (Step previousStep : previousSteps.steps) {
            steps.add(createByCondition(linePosition, previousStep));
        }
        return new Steps(steps, linePosition);
    }

    private static Step createByCondition(int linePosition, Step previousStep) {
        if (previousStep.getLine() == linePosition) {
            return new Step(linePosition - 1, previousStep.getStep(), () -> false);
        }
        return new Step(linePosition, previousStep.getStep(), new RandomMovement());
    }

    public static Steps lastLineSteps(Steps previousLineSteps) {
        List<Step> steps = new ArrayList<>();
        int linePosition = previousLineSteps.linePosition + 1;

        for (Step previousLineStep : previousLineSteps.steps) {
            steps.add(createPrevStep(linePosition, previousLineStep));
        }
        return new Steps(steps, linePosition);
    }

    private static Step createPrevStep(int linePosition, Step previousLineStep) {
        if (previousLineStep.getLine() == linePosition) {
            return new Step(linePosition - 1, previousLineStep.getStep(), () -> false);
        }
        return new Step(linePosition, previousLineStep.getStep(), () -> false);
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Step get(int i) {
        return steps.get(i);
    }

    public int size() {
        return steps.size();
    }
}
