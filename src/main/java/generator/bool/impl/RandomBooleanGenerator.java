package generator.bool.impl;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RandomBooleanGenerator implements BooleanSupplier {

    private Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean getAsBoolean() {
        return random.nextBoolean();
    }
}
