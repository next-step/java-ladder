package nextstep.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLineStrategy implements LineStrategy {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private static final RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

    public static RandomLineStrategy getInstance() {
        return randomLineStrategy;
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
