package nextstep.ladder.Strategy;

import java.util.Random;

public class RandomConnectBrideStrategy implements ConnectBridgeStrategy {
    private static final Random random = new Random();

    @Override
    public boolean makeBridge() {
        return random.nextBoolean();
    }
}
