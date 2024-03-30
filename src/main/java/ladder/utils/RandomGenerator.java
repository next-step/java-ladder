package ladder.utils;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 10;

    public static int generate() {
        return RANDOM.nextInt(MAX_NUMBER) % 2;
    }
}
