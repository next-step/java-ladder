package ladder.model;

import java.util.Random;

public class RandomBooleanGenerator {
    private static final Random random = new Random();

    public static boolean generate() {
        return random.nextBoolean();
    }
}
