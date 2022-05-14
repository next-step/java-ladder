package ladder.domain.step;

import utils.RandomUtils;

import static ladder.view.OutputView.CROSSABLE_STEP;
import static ladder.view.OutputView.UN_CROSSABLE_STEP;

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

    @Override
    public String toString() {
        if (isCrossable()) {
            return CROSSABLE_STEP;
        }
        return UN_CROSSABLE_STEP;
    }
}
