package ladder.domain;

import java.util.Random;

public class RandomDirectionStrategy extends DirectionStrategy {
    private static final Random random = new Random();

    private RandomDirectionStrategy() {}

    public static RandomDirectionStrategy getInstance() {
        return SingletonHelper.instance;
    }

    @Override
    Direction get() {
        return get(random.nextBoolean());
    }

    private static class SingletonHelper {
        private static final RandomDirectionStrategy instance = new RandomDirectionStrategy();
    }
}
