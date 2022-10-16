package nextstep.ladder.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final Random RANDOM = ThreadLocalRandom.current();

    private RandomGenerator() {
    }

    public static boolean halfBoolean() {
        return RANDOM.nextBoolean();
    }
}
