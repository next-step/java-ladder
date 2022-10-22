package nextstep.ladder.Strategy;

import java.util.Random;

public class RandomConnectBrideStrategy implements ConnectBridgeStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean makeBridge() {
        return RANDOM.nextBoolean();
    }
}
