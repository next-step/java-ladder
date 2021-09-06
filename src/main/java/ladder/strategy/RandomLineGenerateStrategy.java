package ladder.strategy;

import java.util.Random;

public class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private RandomLineGenerateStrategy() {
    }

    private static final class LazyHolder {
        private static final RandomLineGenerateStrategy instance = new RandomLineGenerateStrategy();
    }

    public static RandomLineGenerateStrategy getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public boolean generateLine() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
