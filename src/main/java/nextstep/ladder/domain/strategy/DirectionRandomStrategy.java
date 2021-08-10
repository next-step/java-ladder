package nextstep.ladder.domain.strategy;

import java.util.Random;

public class DirectionRandomStrategy implements DirectionStrategy {
    private final Random random;

    private DirectionRandomStrategy(final Random random) {
        this.random = random;
    }

    public static DirectionRandomStrategy getInstance() {
        return RandomBooleanGeneratorHolder.INSTANCE;
    }

    @Override
    public boolean isPossible() {
        return random.nextBoolean();
    }

    private static class RandomBooleanGeneratorHolder {
        private static final DirectionRandomStrategy INSTANCE = new DirectionRandomStrategy(new Random());
    }
}
