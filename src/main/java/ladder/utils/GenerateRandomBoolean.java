package ladder.utils;

import java.util.Random;

public class GenerateRandomBoolean {
    private static final Random random = new Random();

    public static boolean isMove() {
        return random.nextBoolean();
    }
}
