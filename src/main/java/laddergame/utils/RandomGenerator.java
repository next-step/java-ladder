package laddergame.utils;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 2;

    private RandomGenerator() {
    }

    public static int create() {
        return RANDOM.nextInt(BOUND);
    }
}
