package generator.bool.impl;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class ProbabilityBasedGenerator implements BooleanSupplier {

    private static final int UPPER_BOUND_INCLUSIVE = 100;

    private static final int UNDER_BOUND_INCLUSIVE = 1;

    private final Random random;

    private final int percentage;

    public ProbabilityBasedGenerator(int percentage) {
        this.random = new Random();
        this.percentage = percentage;
    }

    @Override
    public boolean getAsBoolean() {
        int randomNumber = random.nextInt(UPPER_BOUND_INCLUSIVE) + UNDER_BOUND_INCLUSIVE;
        if (randomNumber <= percentage) {
            return true;
        }
        return false;
    }
}
