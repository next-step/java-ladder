package ladder.strategy;

import java.util.Random;

public class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private RandomLineGenerateStrategy() {
    }

    private static final class LazyHolder {
        private static final RandomLineGenerateStrategy instance = new RandomLineGenerateStrategy();
        private static final Random random = new Random();
    }

    public static RandomLineGenerateStrategy getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public boolean generateLine() {
        return LazyHolder.random.nextBoolean();
    }

}
