package ladderstep4.ladder.util;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {}

    public static boolean randomBoolean() {
        return RANDOM.nextBoolean();
    }
}
