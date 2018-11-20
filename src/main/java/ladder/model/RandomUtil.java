package ladder.model;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

}
