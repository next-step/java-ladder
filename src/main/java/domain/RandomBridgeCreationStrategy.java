package domain;

import java.util.Random;

public class RandomBridgeCreationStrategy implements BridgeCreationStrategy {

    public final Random random = new Random();

    @Override
    public boolean isCreate() {
        return random.nextBoolean();
    }
}
