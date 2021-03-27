package ladder.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_SIZE = 2;

    private static Random random = new Random();

    public static int value() {
        return random.nextInt(RANDOM_SIZE);
    }
}
