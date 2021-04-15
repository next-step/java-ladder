package ladder.util;

import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();

    public static boolean trueOrFalse() {
        return random.nextBoolean();
    }
}
