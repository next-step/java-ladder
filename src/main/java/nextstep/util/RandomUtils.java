package nextstep.util;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
