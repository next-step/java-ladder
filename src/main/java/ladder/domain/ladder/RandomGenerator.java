package ladder.domain.ladder;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    private RandomGenerator() {}

    public static boolean isMovable() {
        return random.nextBoolean();
    }
}
