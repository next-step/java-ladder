package ladder.domain;

import java.util.Random;

public class RandomConnectingStrategy implements ConnectingStrategy {
    private static final Random random = new Random();

    @Override
    public boolean connectable() {
        return random.nextBoolean();
    }
}