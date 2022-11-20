package ladder.util;

import ladder.strategy.ConnectionStrategy;

import java.util.Random;

public class RandomUtil implements ConnectionStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isConnected() {
        return random.nextBoolean();
    }

}
