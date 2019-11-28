package ladder.structure;

import ladder.structure.connection.Connection;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;
import ladder.structure.connection.result.Points;

import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private static final int DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH = 1;
//    private final Connections connections;
    private final Points points;

    public LineOfLadder(int participantsSize,
                        ConnectionStrategy connectionStrategy) {
        int width = calculateWidth(participantsSize);
//        this.connections = new Connections(width, connectionStrategy);
        this.points = new Points(width, connectionStrategy);
    }

    private int calculateWidth(int participantsSize) {
        return participantsSize - DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(points.getConnections());
        //return Collections.unmodifiableList(connections.getConnections());
    }

    public Points movePoints(ConnectionStrategy connectionStrategy) {
        return points.movePoints(connectionStrategy);
//        return connections.movePoints(before);
    }
    public Points movePoints() {
        return points.movePoints();
//        return connections.movePoints(before);
    }
}


