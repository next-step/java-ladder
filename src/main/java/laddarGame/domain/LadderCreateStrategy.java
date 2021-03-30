package laddarGame.domain;

import java.util.Random;

public class LadderCreateStrategy implements CreateStrategy {

    private static final Random random = new Random();

    @Override
    public boolean test(boolean lastPoint) {
        if (lastPoint) {
            return false;
        }
        return random.nextBoolean();
    }

    private LadderCreateStrategy() {
    }

    private static class StrategyHolder {
        public static final LadderCreateStrategy INSTANCE = new LadderCreateStrategy();
    }

    public static LadderCreateStrategy getInstance() {
        return StrategyHolder.INSTANCE;
    }
}
