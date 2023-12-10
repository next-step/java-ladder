package nextstep.ladder.model;

import java.util.Objects;

public class Step {

    private final Boolean currentStep;
    private final Boolean previousStep;

    private Step(Boolean currentStep, Boolean previousStep) {
        this.currentStep = currentStep;
        this.previousStep = previousStep;
    }

    public static Step of(Boolean currentStep, Boolean previousStep) {
        return new Step(currentStep, previousStep);
    }

    public static Step stepPreviousIsFalse(Boolean currentStep) {
        return of(currentStep, false);
    }

    public static Step stepCurrentIsFalse(Boolean previousStep) {
        return of(false, previousStep);
    }

    public boolean canMove() {
        return this.currentStep;
    }

    public Boolean currentStep() {
        return currentStep;
    }

    public Boolean previousStep() {
        return previousStep;
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

}
