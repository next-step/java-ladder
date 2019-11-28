package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;

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

    public Points getPointsAfterConnection(Points before) {
        return connections.getAfterPoints(before);
    }
}


