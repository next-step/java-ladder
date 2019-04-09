package util;

import java.util.Random;

public class BridgeGenerator {
    private static final Random random;

    static {
        random = new Random();
    }

    public static boolean generate(boolean left) {
        if (left) {
            return false;
        }
        return random.nextBoolean();
    }
}
