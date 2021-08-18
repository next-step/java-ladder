package ladder.utils;

import java.util.Random;

public class RandomPointGenerator {

    private static final Random RANDOM = new Random();

    private RandomPointGenerator() {
    }

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}
