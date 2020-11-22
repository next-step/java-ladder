package ladder.strategy;

import java.util.Random;

public class RandomStrategy extends Strategy {
    private static final Random random = new Random();

    private RandomStrategy() {}

    public static RandomStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    public Boolean get() {
        return random.nextBoolean();
    }

    private static class SingletonHelper {
        private static final RandomStrategy instance = new RandomStrategy();
    }
}
