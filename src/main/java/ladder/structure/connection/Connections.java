package ladder.structure.connection;

import ladder.game.Point;
import ladder.game.Points;
import ladder.structure.Connection;

import java.util.ArrayList;
import java.util.List;

import static ladder.structure.Connection.NOT_CONNECTED_BRIDGE;

public class Connections {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private List<Connection> connections;

    public Connections(int ladderWidth,
                       ConnectionStrategy connectionStrategy) {
        this.connections = new ArrayList<>();
        addConnections(ladderWidth, connectionStrategy);
    }

    public Points getAfterPoints(Points before) {
        return checkPointsForNextLine(before.getPoints());
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public Connection get(int index) {
        if (index < 0 || index >= connections.size()) {
            return NOT_CONNECTED_BRIDGE;
        }
        return connections.get(index);
    }

    private void addConnections(int ladderWidth, ConnectionStrategy connectionStrategy) {
        Connection before = null;
        for (int width = 0; width < ladderWidth; width++) {
            before = Connection.of(connectionStrategy, before);
            connections.add(before);
        }
    }

    private Points checkPointsForNextLine(List<Point> nowPoints) {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point nowPoint : nowPoints) {
            pointsAfterConnection.add(checkPointForNextLine(nowPoint));
        }
        return new Points(pointsAfterConnection);
    }

    private Point checkPointForNextLine(Point point) {
        int index = point.value();
        if (get(index + CONNECTION_TO_RIGHT).isConnected()) {
            return Point.of(index + MOVE_RIGHT);
        }
        if (get(index + CONNECTION_TO_LEFT).isConnected()) {
            return Point.of(index + MOVE_LEFT);
        }
        return Point.of(index + MOVE_STRAIGHT);
    }
}
