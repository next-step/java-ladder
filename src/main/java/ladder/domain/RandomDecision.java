package ladder.domain;

import java.util.Random;

public class RandomDecision implements BridgeDecision {
    @Override
    public boolean isBridgeTarge() {
        Random random = new Random();
        return random.nextInt(2) == 0 ? true : false;
    }
}
