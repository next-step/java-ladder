package domain.bridge;

import java.util.Random;

public class BridgeRandomGenerator implements BridgeGenerator {

    private Random random;

    public BridgeRandomGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generate(boolean left) {
        if (left) {
            return false;
        }
        return random.nextBoolean();
    }
}
