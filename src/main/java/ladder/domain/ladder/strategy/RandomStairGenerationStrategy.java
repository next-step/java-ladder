package ladder.domain.ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStairGenerationStrategy implements StairGenerationStrategy {

    public RandomStairGenerationStrategy() {
    }

    @Override
    public boolean generate() {
        return ThreadLocalRandom.current()
                .nextBoolean();
    }
}
