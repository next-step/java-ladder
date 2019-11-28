package ladder.structure.connection;

import ladder.structure.connection.result.Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.structure.connection.Connection.NOT_CONNECTED_BRIDGE;

public class Connections {
    private final List<Connection> connections;

    public Connections(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.connections = addConnections(ladderWidth, connectionStrategy);
    }

    public Points movePoints(Points before) {
        if (before == null) {
            before = new Points(connections.size());
        }
        return before.move(this);
    }

    public boolean isConnected(int index) {
        if (index < 0 || index >= connections.size()) {
            return NOT_CONNECTED_BRIDGE.isConnected();
        }
        return connections.get(index).isConnected();
    }

    private List<Connection> addConnections(int ladderWidth, ConnectionStrategy connectionStrategy) {
        Connection before = null;
        List<Connection> connections = new ArrayList<>();
        for (int width = 0; width < ladderWidth; width++) {
            before = Connection.of(connectionStrategy, before);
            connections.add(before);
        }
        return Collections.unmodifiableList(connections);
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }
}
