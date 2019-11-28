package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;

import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private final Points pointsAfterConnection;
    private final Connections connections;

    public LineOfLadder(int ladderWidth,
                        ConnectionStrategy connectionStrategy,
                        Points points) {
        this.connections = new Connections(ladderWidth, connectionStrategy);
        this.pointsAfterConnection = connections.getAfterPoints(points);
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections.getConnections());
    }

    public Points getPointsAfterConnection() {
        return this.pointsAfterConnection;
    }
}


