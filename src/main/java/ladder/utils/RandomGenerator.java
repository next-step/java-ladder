package ladder.utils;

import java.util.Random;
import ladder.model.LadderBridge;

public final class RandomGenerator {
    private static final Random randomNumberGenerator = new Random();

    public static int create() {
        return randomNumberGenerator.nextInt(LadderBridge.VALUES_SIZE);
    }
}
