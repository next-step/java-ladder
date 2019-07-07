package domain.bridge;

import java.util.Random;

public class BridgeRandomGenerator implements BridgeGenerator {
    private Random random;
    private int limitValue;

    public BridgeRandomGenerator(int limitValue) {
        this.random = new Random();
        this.limitValue = limitValue;
    }

    @Override
    public boolean generate(boolean left) {
        if (left) {
            return false;
        }

        return random.nextInt(10) < this.limitValue ? Boolean.TRUE : Boolean.FALSE;
    }
}
