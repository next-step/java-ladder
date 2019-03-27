package generator;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RandomBooleanGenerator implements BooleanSupplier {

    Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean getAsBoolean() {
        return random.nextBoolean();
    }
}
