package nextstep.ladder.data;

import java.util.Arrays;

public enum StepType {
    EMPTY(false),
    STEP(true);

    private final boolean value;

    StepType(boolean value) {
        this.value = value;
    }

    public static StepType of(boolean value) {
        if (isStep(value)) {
            return StepType.STEP;
        }

        return StepType.EMPTY;
    }

    private static boolean isStep(boolean value) {
        return value;
    }
}
