package ladder.domain;

import java.util.Random;

public class BooleanGenerator {
    private static final Random random = new Random();

    private BooleanGenerator() {
    }

    public static boolean generatePoint() {
        return random.nextBoolean();
    }
}
