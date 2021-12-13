package ladder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

public class RandomStrategy implements BooleanSupplier {
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    @Override
    public boolean getAsBoolean() {
        if (threadLocalRandom.nextInt() % 2 == 0) {
            return false;
        }

        return true;
    }
}
