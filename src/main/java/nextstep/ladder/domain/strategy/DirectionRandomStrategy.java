package nextstep.ladder.domain.strategy;

import java.util.Random;

public class DirectionRandomStrategy implements DirectionStrategy {
    private final Random random;

    private DirectionRandomStrategy(final Random random) {
        this.random = random;
    }

    public static DirectionRandomStrategy getInstance() {
        return DirectionRandomStrategyHolder.INSTANCE;
    }

    @Override
    public boolean isPossible() {
        return random.nextBoolean();
    }

    private static class DirectionRandomStrategyHolder {
        private static final DirectionRandomStrategy INSTANCE = new DirectionRandomStrategy(new Random());
    }
}
