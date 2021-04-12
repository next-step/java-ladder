package nextstep.ladder.strategy;

import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {
    private static final Random random = new Random();

    @Override
    public boolean isConnectable() {
        return random.nextBoolean();
    }
}
