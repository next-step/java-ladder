package ladder.domain;

import java.util.Random;

public class RandomStrategy implements CreateStrategy {
    private static RandomStrategy INSTANCE = null;
    private static final Random random = new Random();
    private RandomStrategy() {
    }

    public static RandomStrategy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RandomStrategy();
        }
        return INSTANCE;
    }

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}
