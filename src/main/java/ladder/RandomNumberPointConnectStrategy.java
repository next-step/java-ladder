package ladder;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberPointConnectStrategy implements PointConnectStrategy {
    private static final int RANDOM_THRESHOLD = 4;
    private static final int RANDOM_MAX = 10;

    @Override
    public boolean isConnected() {
        return ThreadLocalRandom.current().nextInt(RANDOM_MAX) > RANDOM_THRESHOLD;
    }

}
