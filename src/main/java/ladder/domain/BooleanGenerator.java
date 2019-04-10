package ladder.domain;

import java.util.Random;

public class BooleanGenerator {
    private static final Random random = new Random();

    private BooleanGenerator() {
    }

    public static boolean pick() {
        return random.nextBoolean();
    }

    public static boolean pick(boolean prev) {
        boolean value = random.nextBoolean();
        if(prev && value) {
            return false;
        }
        return value;
    }
}
