package nextstep.ladder.common;

import java.util.Random;

public class RandomGenerator {

    private final static Random random = new Random();

    private RandomGenerator() {
    }

    public static boolean createRandomBoolean() {
        return random.nextBoolean();
    }
}
