package ladder.util;

import java.util.Random;

public class RandomValueGenerator {
    private static Random random = new Random();

    public static boolean generate() {
        return random.nextBoolean();
    }
}
