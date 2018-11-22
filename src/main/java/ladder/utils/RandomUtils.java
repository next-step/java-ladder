package ladder.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {

    }

    public static int generate(int max) {
        return RANDOM.nextInt(max);
    }
}
