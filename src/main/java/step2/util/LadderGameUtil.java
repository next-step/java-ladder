package step2.util;

import java.util.Random;

public class LadderGameUtil {

    public static final Random RANDOM = new Random();

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
