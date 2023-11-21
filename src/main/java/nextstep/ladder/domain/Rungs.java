package nextstep.ladder.domain;

import java.util.function.BooleanSupplier;

public class Rungs {
    private final Boolean[] rungs;

    public Rungs(final int width, final BooleanSupplier lineBuilderStrategy) {
        final Boolean[] result = new Boolean[width];

        result[0] = lineBuilderStrategy.getAsBoolean();

        for (int idx = 1; idx < result.length; idx++) {
            final boolean preBool = result[idx - 1];
            final boolean curBool = lineBuilderStrategy.getAsBoolean();

            result[idx] = adjustContinuousTrue(preBool, curBool);
        }

        this.rungs = result;
    }

    private boolean adjustContinuousTrue(final boolean preBool, boolean curBool) {
        if (preBool) {
            curBool = false;
        }

        return curBool;
    }

    public int size() {
        return this.rungs.length;
    }

    public Boolean[] rungs() {
        return rungs;
    }

    public boolean hasRungAtIdx(final int idx) {
        return this.rungs[idx];
    }
}
