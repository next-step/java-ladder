package nextstep.ladder.domain.strategy;

import java.util.Objects;
import java.util.Random;

public class RandomStepGenerateStrategy implements StepGenerateStrategy {
    public static final RandomStepGenerateStrategy HALF_PERCENT_STEP_STRATEGY = new RandomStepGenerateStrategy(new Random());

    private final Random random;

    private RandomStepGenerateStrategy(Random random) {
        validate(random);

        this.random = random;
    }

    private void validate(Random random) {
        if (Objects.isNull(random)) {
            throw new IllegalArgumentException("Random can't be null");
        }
    }

    public static RandomStepGenerateStrategy init(Random random) {
        return new RandomStepGenerateStrategy(random);
    }

    @Override
    public boolean isGenerable() {
        return random.nextBoolean();
    }
}
