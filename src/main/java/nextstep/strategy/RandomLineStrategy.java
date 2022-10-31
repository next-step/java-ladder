package nextstep.strategy;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
