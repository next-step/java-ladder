package ladder.booleangenerator;

import java.util.Random;

public class NextBooleanGenerator {
    private static final Random random = new Random();

    public static boolean generate(boolean prev) {
        return prev ? false : random.nextBoolean();
    }
}