package ladderinterface.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    private RandomGenerator() {
        throw new AssertionError();
    }

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }

}
