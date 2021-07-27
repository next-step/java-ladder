package nextstep.ladder.domain.strategy;

import java.util.Random;

public class RandomStepGenerateStrategy implements StepGenerateStrategy {
    public static final RandomStepGenerateStrategy HALF_PERCENT_STEP_STRATEGY = new RandomStepGenerateStrategy(new Random());

    private final Random random;

    private RandomStepGenerateStrategy(Random random) {
        this.random = random;
    }

    public static Object init(Random random) {
        return new RandomStepGenerateStrategy(random);
    }

    @Override
    public boolean isGenerable() {
        return random.nextBoolean();
    }
}
