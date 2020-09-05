package ladder.utils;

import java.util.Random;

public class RandomBoolGenerator {
    private static final Random GENERATOR = new Random();

    public static boolean generate() {
        return GENERATOR.nextBoolean();
    }
}
