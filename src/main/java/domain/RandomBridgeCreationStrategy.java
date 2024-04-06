package domain;

import java.util.Random;

public class RandomBridgeCreationStrategy implements BridgeCreationStrategy {

    private static final Random random = new Random();

    @Override
    public boolean isCreate() {
        return random.nextBoolean();
    }
}
