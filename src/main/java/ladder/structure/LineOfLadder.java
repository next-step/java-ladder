package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;

import java.util.List;

public class LineOfLadder {
    private final Points pointsAfterConnection;
    private final Connections connections;

    public LineOfLadder(int ladderWidth,
                        ConnectionStrategy connectionStrategy,
                        List<Integer> pointsBeforeConnection) {
        this.connections = new Connections(ladderWidth, connectionStrategy);
        this.pointsAfterConnection = new Points(connections, ladderWidth, pointsBeforeConnection);
    }

    public List<Connection> getConnections() {
        return connections.getConnections();
    }

    public List<Integer> getPointsAfterConnection() {
        return this.pointsAfterConnection.getPoints();
    }
}


