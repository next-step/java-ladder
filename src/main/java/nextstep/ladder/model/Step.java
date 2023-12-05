package nextstep.ladder.model;

import java.util.Objects;

public class Step {

    private final Boolean currentStep;
    private final Boolean previousStep;

    private Step(Boolean currentStep, Boolean previousStep) {
        this.currentStep = currentStep;
        this.previousStep = previousStep;
    }

    public static Step from(Boolean currentStep, Boolean previousStep){
        return new Step(currentStep, previousStep);
    }

    public static Step emptyStep() {
        return new Step(false, false);
    }

    public Step overlapStepReplace(Boolean previousStep) {
        if (currentStep.equals(previousStep) && previousStep.equals(true)) {
            return new Step(false, false);
        }
        return new Step(currentStep, previousStep);
    }

    public boolean canMove() {
        return this.currentStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Step step1 = (Step) o;
        return Objects.equals(currentStep, step1.currentStep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentStep);
    }

    public Boolean currentStep() {
        return currentStep;
    }
}
