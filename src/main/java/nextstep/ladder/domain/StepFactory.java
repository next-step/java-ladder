package nextstep.ladder.domain;

import java.util.Random;

public class StepFactory {
    private boolean previousStep;

    public StepFactory() {
        this(false);
    }
    public StepFactory(boolean previousStep) {
        this.previousStep = previousStep;
    }

    public boolean next() {
        if (previousStep) {
            this.previousStep = false;
            return false;
        }
        this.previousStep = new Random().nextBoolean();
        return this.previousStep;
    }
}
