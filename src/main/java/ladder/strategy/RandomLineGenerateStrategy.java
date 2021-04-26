package ladder.strategy;

import java.util.Random;

public final class RandomLineGenerateStrategy implements LineGenerateStrategy {

    private static final class RandomCrossGenerateStrategyHolder {
        private static final RandomLineGenerateStrategy instance = new RandomLineGenerateStrategy();
    }

    public static final RandomLineGenerateStrategy getInstance() {
        return RandomCrossGenerateStrategyHolder.instance;
    }

    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }

}
