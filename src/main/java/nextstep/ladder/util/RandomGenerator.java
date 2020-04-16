package nextstep.ladder.util;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static boolean generate() {
        return random.nextBoolean();
    }
}
