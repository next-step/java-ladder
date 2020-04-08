package ladder.randomgenerator;

import java.util.Random;

public class BooleanGenerator {
    private static final Random random = new Random();

    public static boolean getNextBoolean(boolean prev) {
        return prev ? false : random.nextBoolean();
    }
}