package ladder.generator;

import ladder.domain.Bridge;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomBridgeGenerator implements BridgeGenerator {
    private final SecureRandom random = new SecureRandom();

    @Override
    public List<Bridge> generate(int playerCount) {

        List<Bridge> bridges = new ArrayList<>();

        Bridge bridge = new Bridge(random.nextBoolean());
        bridges.add(bridge);

        for (int i = 1; i < playerCount - 1; i++) {
            bridge = nonContinuousConnected(bridge);
            bridges.add(bridge);
        }

        return bridges;
    }

    private Bridge nonContinuousConnected(Bridge bridge) {
        if(bridge.isConnected()) {
            return new Bridge(false);
        }
        return new Bridge(random.nextBoolean());
    }
}
