package study.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
