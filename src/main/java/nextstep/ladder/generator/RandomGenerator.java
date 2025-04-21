package nextstep.ladder.generator;

import java.util.Random;

public class RandomGenerator {
    public static final Random RANDOM = new Random();
    public static boolean generate() {
        return RANDOM.nextBoolean();
    }
}

