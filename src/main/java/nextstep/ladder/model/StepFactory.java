package nextstep.ladder.model;

public class StepFactory {

    public Step firstStep(RandomLineGenerator randomLineGenerator) {
        return Step.stepPreviousIsFalse(randomLineGenerator.randomStep());
    }

    public Step lastStep(Boolean previousStep) {
        return Step.stepCurrentIsFalse(previousStep);
    }

    private Step normalStep(Boolean currentStep, Boolean previousStep) {
        return Step.of(currentStep, previousStep);
    }

    private Step randomStep(Boolean previousStep, RandomLineGenerator randomLineGenerator) {
        return Step.of(randomLineGenerator.randomStep(), previousStep);
    }

    public Step createStep(boolean previousStep, RandomLineGenerator randomLineGenerator) {
        if (previousStep) {
            return normalStep(false, previousStep);
        } else {
            return randomStep(previousStep, randomLineGenerator);
        }
    }
}
