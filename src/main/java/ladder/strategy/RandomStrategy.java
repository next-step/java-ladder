package ladder.strategy;

import java.util.Random;

public class RandomStrategy implements LadderGenerationStrategy {
    private final Random random;

    public RandomStrategy() {
        random = new Random();
    }

    public RandomStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean first() {
        return random.nextBoolean();
    }

    @Override
    public boolean next(boolean prev) {
        if (!prev) {
            return random.nextBoolean();
        }
        return false;
    }
}
