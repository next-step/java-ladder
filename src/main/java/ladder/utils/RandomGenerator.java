package ladder.utils;

import ladder.model.LadderBridge;

import java.util.Random;

public class RandomGenerator {
    private static final Random randomNumberGenerator = new Random();

    public static int create() {
        return randomNumberGenerator.nextInt(LadderBridge.VALUES_SIZE);
    }
}
