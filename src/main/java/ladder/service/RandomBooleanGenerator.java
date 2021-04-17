package ladder.service;

import java.util.Random;

public class RandomBooleanGenerator implements RandomBoolean {
    Random random = new Random();
    private final int DEFAULT_PROBABILITY = 50;
    private final int MAX_PROBABILITY = 100;

    @Override
    public boolean randomBoolean() {
        if (random.nextInt(MAX_PROBABILITY) <= DEFAULT_PROBABILITY) {
            return true;
        }
        return false;
    }
}
