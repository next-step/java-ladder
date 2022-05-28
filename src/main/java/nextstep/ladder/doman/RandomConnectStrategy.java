package nextstep.ladder.doman;

import java.util.Random;

public class RandomConnectStrategy implements PointConnectStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isConnected() {
        return random.nextBoolean();
    }
}
