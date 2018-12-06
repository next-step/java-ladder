package ladder.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int MAX_PERCENT = 100;

    public static boolean generate() {
        return RANDOM.nextBoolean();
    }

    public static boolean generate(int percentage) {
        return (RANDOM.nextInt(MAX_PERCENT) < percentage);
    }
}
