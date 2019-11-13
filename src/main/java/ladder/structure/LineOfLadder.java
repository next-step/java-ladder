package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private List<Boolean> connections;

    public LineOfLadder(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.connections = new ArrayList<>();
        createLine(ladderWidth, connectionStrategy);
    }

    public boolean isConnected(int index) {
        return connections.get(index);
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    private void createLine(int ladderWidth, ConnectionStrategy connectionStrategy) {
        for (int width = 0; width < ladderWidth; width++) {
            connections.add(createConnection(connectionStrategy));
        }
    }

    private boolean createConnection(ConnectionStrategy connectionStrategy) {
        int connectedCount = connections.size();
        if (connectedCount != 0 && connections.get(connectedCount - 1)) {
            return false;
        }
        return connectionStrategy.create();
    }
}


