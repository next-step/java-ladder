package nextstep.strategy;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private static final Random random = new Random();

    private static final RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

    public static RandomLineStrategy getInstance() {
        return randomLineStrategy;
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
