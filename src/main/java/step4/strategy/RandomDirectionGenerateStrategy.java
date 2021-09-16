package step4.strategy;

import java.util.Random;

public class RandomDirectionGenerateStrategy implements DirectionGenerateStrategy {

    private RandomDirectionGenerateStrategy() {
    }

    private static final class LazyHolder {
        private static final RandomDirectionGenerateStrategy instance = new RandomDirectionGenerateStrategy();
        private static final Random random = new Random();
    }

    public static RandomDirectionGenerateStrategy getInstance() {
        return RandomDirectionGenerateStrategy.LazyHolder.instance;
    }

    @Override
    public boolean generateDirection() {
        return LazyHolder.random.nextBoolean();
    }

}
