package ladder.util;

import java.util.Random;

public class CustomRandom {

    private static final Random random = new Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
