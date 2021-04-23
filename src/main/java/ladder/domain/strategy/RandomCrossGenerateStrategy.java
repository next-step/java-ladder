package ladder.domain.strategy;

import java.util.Random;

public final class RandomCrossGenerateStrategy implements CrossGenerateStrategy {

    private static final class RandomCrossGenerateStrategyHolder {
        private static final RandomCrossGenerateStrategy instance = new RandomCrossGenerateStrategy();
    }

    public static final RandomCrossGenerateStrategy getInstance() {
        return RandomCrossGenerateStrategyHolder.instance;
    }

    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }

}
