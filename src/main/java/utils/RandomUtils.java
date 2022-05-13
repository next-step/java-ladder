package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean getBoolean() {
        return RANDOM.nextBoolean();
    }
}
