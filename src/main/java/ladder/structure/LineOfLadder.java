package ladder.structure;

import ladder.structure.connection.Connection;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;
import ladder.structure.connection.result.Points;

import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private final Connections connections;

    public LineOfLadder(int ladderWidth,
                        ConnectionStrategy connectionStrategy) {
        this.connections = new Connections(ladderWidth, connectionStrategy);
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections.getConnections());
    }

    public Points movePoints(Points before) {
        return connections.movePoints(before);
    }
}


