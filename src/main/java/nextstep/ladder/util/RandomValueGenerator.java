package nextstep.ladder.util;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random random = new Random();

    private RandomValueGenerator() {
    }

    public static boolean generate() {
        return random.nextBoolean();
    }
}
