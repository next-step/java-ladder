package nextstep.ladder.domain.strategy;

import java.util.Random;

public class RandomBridgeStrategy implements BridgeStrategy {

    private final Random random = new Random();

    @Override
    public boolean makeBridge() {
        return random.nextBoolean();
    }
}
