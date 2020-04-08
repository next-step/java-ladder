package ladder.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    private RandomUtil() { }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
