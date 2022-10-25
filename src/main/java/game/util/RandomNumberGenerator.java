package game.util;

import java.util.Random;

public class RandomNumberGenerator {
    public static int randomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
