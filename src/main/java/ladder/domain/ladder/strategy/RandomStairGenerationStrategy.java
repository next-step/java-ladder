package ladder.domain.ladder.strategy;

import java.util.Random;

public class RandomStairGenerationStrategy implements StairGenerationStrategy {

    private static final Random random = new Random();

    @Override
    public boolean isGeneratable() {
        return random.nextBoolean();
    }
}
