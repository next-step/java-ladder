package nextstep.ladder.domain;

import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isConnected() {
        return random.nextBoolean();
    }
}
