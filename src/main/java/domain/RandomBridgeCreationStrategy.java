package domain;

import java.util.Random;

public class RandomBridgeCreationStrategy implements BridgeCreationStrategy {

    @Override
    public boolean isCreate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
