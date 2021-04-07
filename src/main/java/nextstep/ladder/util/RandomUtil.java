package nextstep.ladder.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
