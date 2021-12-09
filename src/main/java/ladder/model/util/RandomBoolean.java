package ladder.model.util;

import java.util.Random;

public class RandomBoolean {

    private static final Random random = new Random();

    private RandomBoolean() {}

    public static boolean get() {
        return random.nextBoolean();
    }
}
