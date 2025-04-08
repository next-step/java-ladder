package ladder.generator;

import ladder.domain.Bridge;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public Bridge generate() {
        return Bridge.of(RANDOM.nextBoolean());
    }

}
