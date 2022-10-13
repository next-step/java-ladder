package step4.utils;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}
