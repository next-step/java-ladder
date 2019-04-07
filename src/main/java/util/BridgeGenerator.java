package util;

import java.util.Random;

public class BridgeGenerator {
    private static final Random random;
    static {
        random = new Random();
    }

    public static boolean generate() {
        return random.nextBoolean();
    }

}
