package nextstep.ladder.strategy;

import java.util.Random;

public class RandomStrategyImpl implements RandomStrategy {

    private static final Random random = new Random();

    @Override
    public boolean createLine() {
        return getRandom();
    }

    private boolean getRandom() {
        return random.nextBoolean();
    }
}
