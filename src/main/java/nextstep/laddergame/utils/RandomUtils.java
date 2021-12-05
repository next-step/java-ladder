package nextstep.laddergame.utils;

import java.util.Random;

public final class RandomUtils {

    private static final Random random = new Random();

    private RandomUtils() {
    }

    public static int generate(int limit) {
        return random.nextInt(limit);
    }
}
