package domain;

import java.util.Random;

public class RandomDirectionGenerator {

    private RandomDirectionGenerator() {}

    private static final Random random = new Random();

    public static Direction generate() {
        return random.nextBoolean() ? Direction.RIGHT : Direction.DOWN;
    }
}
