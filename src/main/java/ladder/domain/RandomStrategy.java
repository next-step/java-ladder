package ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStrategy implements ConnectStrategy{

    private static final RandomStrategy INSTANCE = new RandomStrategy();
    private static ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    @Override
    public boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static RandomStrategy getInstance() {
        return INSTANCE;
    }

    private RandomStrategy() {
    }
}
