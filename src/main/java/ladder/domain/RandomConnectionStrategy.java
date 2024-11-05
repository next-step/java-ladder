package ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomConnectionStrategy implements ConnectionStrategy {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public boolean isConnect() {
        return RANDOM.nextBoolean();
    }

}
