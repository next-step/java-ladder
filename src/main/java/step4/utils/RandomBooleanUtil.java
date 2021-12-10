package step4.utils;

import java.util.Random;

public class RandomBooleanUtil {
    private static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
