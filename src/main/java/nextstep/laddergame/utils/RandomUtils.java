package nextstep.laddergame.utils;

import java.util.Random;

public final class RandomUtils {

    private static final int DIRECTION_LIMIT = 2;
    private static final int TRUE_NUMBER = 1;

    private static final Random random = new Random();

    private RandomUtils() {
    }

    public static int generate(int limit) {
        return random.nextInt(limit);
    }

    public static boolean generateDirection() {
        int directionNumber = random.nextInt(DIRECTION_LIMIT);
        return directionNumber == TRUE_NUMBER ? true : false;
    }
}
