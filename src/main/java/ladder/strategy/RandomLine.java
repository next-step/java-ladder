package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLine implements LineStrategy {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean isEnableLine() {
        return random.nextBoolean();
    }

}
