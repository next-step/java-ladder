package laddergame.util;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
