package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLine implements LineStrategy {

    @Override
    public boolean isEnableLine() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextBoolean();
    }

}
