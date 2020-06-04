package ladder.domain.ladder.strategy;

import java.util.Random;

public class RandomStairGenerationStrategy implements StairGenerationStrategy {

    private static final Random random = new Random();

    private RandomStairGenerationStrategy() {
    }

    public static RandomStairGenerationStrategy getInstance() {
        return InnerInstanceClass.instance;
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }

    private static class InnerInstanceClass {
        private static final RandomStairGenerationStrategy instance = new RandomStairGenerationStrategy();
    }

}
