package ladder.generator;

import ladder.domain.Bridge;

import java.util.Queue;

public class FixedBridgeGenerator implements BridgeGenerator {
    private final Queue<Bridge> bridges;

    public FixedBridgeGenerator(Queue<Bridge> bridges) {
        this.bridges = bridges;
    }

    @Override
    public Bridge generate() {
        return bridges.isEmpty() ? Bridge.DISCONNECTED : bridges.poll();
    }
}
