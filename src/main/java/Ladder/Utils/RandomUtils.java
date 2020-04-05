package Ladder.Utils;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static boolean booleanRandom() {
        return random.nextBoolean();
    }
}
