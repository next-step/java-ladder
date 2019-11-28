package ladder.structure.connection.result;

import ladder.structure.connection.Connection;
import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ladder.structure.connection.Connection.NOT_CONNECTED_BRIDGE;

public class Points {
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private final List<Point> points;
    private List<Connection> connections;

    public Points(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.points = IntStream.rangeClosed(0, ladderWidth).boxed().map(Point :: of).collect(toList());
        this.connections = addConnections(ladderWidth, connectionStrategy);
    }

    private Points(List<Point> points) {
        this.points = points;
    }

    private Points(List<Point> points, ConnectionStrategy connectionStrategy) {
        this.points = points;
        this.connections = addConnections(points.size() - 1, connectionStrategy);
    }

    public Points movePoints() {
        return move();
    }

    public Points movePoints(ConnectionStrategy connectionStrategy) {
        return move(connectionStrategy);
    }

    public boolean isConnectedConnection(int index) {
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

    public Points move(ConnectionStrategy connectionStrategy) {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move(
                    isConnectedConnection(before.value() + CONNECTION_TO_LEFT),
                    isConnectedConnection(before.value() + CONNECTION_TO_RIGHT)
            );
            pointsAfterConnection.add(after);
        }
        return new Points(Collections.unmodifiableList(pointsAfterConnection), connectionStrategy);
    }
    public Points move() {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move(
                    isConnectedConnection(before.value() + CONNECTION_TO_LEFT),
                    isConnectedConnection(before.value() + CONNECTION_TO_RIGHT)
            );
            pointsAfterConnection.add(after);
        }
        return new Points(Collections.unmodifiableList(pointsAfterConnection));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
