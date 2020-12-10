package domain;

import java.util.Random;

public class RandomDirectionGenerator {
    private static final Random random = new Random();

    private RandomDirectionGenerator() {}

    public static Boolean generate() {
        return random.nextBoolean();
    }
}
