package ladder.service;

import java.util.Random;

public class StepRandomStrategy implements StepStrategy {
    private final Random random;
    private Boolean beforeStep = false;

    public StepRandomStrategy() {
        this.random = new Random();
    }

    StepRandomStrategy(Random random) {
        this.random = random;
    }

    @Override
    public Boolean nextStep() {
        this.beforeStep = step();
        return this.beforeStep;
    }

    private Boolean step() {
        if (beforeStep) {
            return false;
        }

        return random.nextBoolean();
    }
}
