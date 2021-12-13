package domain;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}
