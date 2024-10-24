package ladder.domain;

import java.util.Random;

public class RandomDecision implements BridgeDecision {
    private static Random random = new Random();
    @Override
    public boolean isBridgeTarge() {
        return random.nextBoolean();
    }
}
