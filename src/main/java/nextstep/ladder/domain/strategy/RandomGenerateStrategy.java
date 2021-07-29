package nextstep.ladder.domain.strategy;

import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;
import java.util.Random;

public class RandomGenerateStrategy implements StepGenerateStrategy {
    public static final RandomGenerateStrategy HALF_PERCENT_STEP_STRATEGY = new RandomGenerateStrategy(new Random());

    private final Random random;

    private RandomGenerateStrategy(Random random) {
        validate(random);

        this.random = random;
    }

    private void validate(Random random) {
        if (Objects.isNull(random)) {
            throw new NullArgumentException(Random.class);
        }
    }

    public static RandomGenerateStrategy init(Random random) {
        return new RandomGenerateStrategy(random);
    }

    @Override
    public boolean isGenerable() {
        return random.nextBoolean();
    }
}
