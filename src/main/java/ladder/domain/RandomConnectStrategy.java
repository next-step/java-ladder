package ladder.domain;

import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {
    private static final Random random = new Random();

    @Override
    public boolean connectable(boolean connect) {
        if (connect) {
            return false;
        }
        return random.nextBoolean();
    }
}
