package cc.oakk.ladder.util;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
        //no instance
    }

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}
