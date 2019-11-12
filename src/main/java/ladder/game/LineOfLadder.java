package ladder.game;

import java.util.ArrayList;
import java.util.List;

public class LineOfLadder {
    private List<Boolean> connections;
    private ConnectionStrategy connectionStrategy;

    public LineOfLadder(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.connections = new ArrayList<>();
        this.connectionStrategy = connectionStrategy;
        createLine(ladderWidth);
    }

    public boolean isConnected(int index) {
        return connections.get(index);
    }

    private void createLine(int ladderWidth) {
        for (int width = 0; width < ladderWidth; width++) {
            connections.add(createConnection());
        }
    }

    private boolean createConnection() {
        int connectedCount = connections.size();
        if (connectedCount != 0 && connections.get(connectedCount - 1)) {
            return false;
        }
        return connectionStrategy.create();
    }
}


