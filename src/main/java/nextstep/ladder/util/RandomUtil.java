package nextstep.ladder.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();
    private static final int MAXIMUM_RANDOM_NUMBER = 2;

    public static int generator() {
        return random.nextInt(MAXIMUM_RANDOM_NUMBER);
    }

}
