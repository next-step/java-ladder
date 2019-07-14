package ladder.domain;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }
}
