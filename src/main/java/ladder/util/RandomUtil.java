package ladder.util;

import ladder.strategy.RandomStrategy;

import java.util.Random;

public class RandomUtil implements RandomStrategy {
    private static final Random random = new Random();

    @Override
    public boolean randomBoolean() {
        return random.nextBoolean();
    }

}
