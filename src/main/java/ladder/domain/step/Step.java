package ladder.domain.step;

import utils.RandomUtils;

public class Step {
    private final boolean crossable;

    public Step() {
        this(RandomUtils.getBoolean());
    }

    public Step(boolean crossable) {
        this.crossable = crossable;
    }

    public boolean isCrossable() {
        return crossable;
    }

    public static Step first() {
        return new Step();
    }

    public static Step from(Step previousStep) {
        if (previousStep.isCrossable()) {
            return new Step(false);
        }

        return new Step();
    }
}
