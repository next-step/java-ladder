package laddergame.domain.ladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FixedConnectGenerator implements BridgeConnectGenerator {
    private final Queue<Boolean> fixedConnections;

    public FixedConnectGenerator(List<Boolean> fixedConnections) {
        this.fixedConnections = new LinkedList<>(fixedConnections);
    }

    @Override
    public boolean generateConnectionState() {
        return fixedConnections.poll();
    }
}
