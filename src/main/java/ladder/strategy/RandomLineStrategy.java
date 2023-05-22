package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLineStrategy implements LineStrategy {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public boolean isConnectable() {
        return RANDOM.nextBoolean();
    }

}
