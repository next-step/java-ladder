package ladder.domain.ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStairGenerationStrategy implements StairGenerationStrategy {

    private RandomStairGenerationStrategy() {
    }

    public static RandomStairGenerationStrategy getInstance() {
        return InnerInstanceClass.instance;
    }

    @Override
    public boolean generate() {
        return ThreadLocalRandom.current()
                .nextBoolean();
    }

    private static class InnerInstanceClass {
        private static final RandomStairGenerationStrategy instance = new RandomStairGenerationStrategy();
    }

}
