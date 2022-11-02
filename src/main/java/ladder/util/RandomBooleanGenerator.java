package ladder.util;

import java.util.Random;

public class RandomBooleanGenerator {

    private static final Random RANDOM = new Random();

    private RandomBooleanGenerator() {
    }

    public static boolean generator() {
        return RANDOM.nextBoolean();
    }
}
