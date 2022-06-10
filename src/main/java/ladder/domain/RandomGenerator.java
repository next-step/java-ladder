package ladder.domain;

import java.util.Random;

public class RandomGenerator {

    public static boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
