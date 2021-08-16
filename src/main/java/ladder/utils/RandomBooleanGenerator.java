package ladder.utils;

import java.util.Random;

public class RandomBooleanGenerator {
    private static final Random random = new Random();

    public static final boolean execute() {
        return random.nextBoolean();
    }
}
