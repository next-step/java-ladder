package ladder.utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    public static boolean nextBoolean() {
        return new Random().nextBoolean();
    }
}
