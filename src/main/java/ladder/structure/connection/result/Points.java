package ladder.structure.connection.result;

import ladder.structure.connection.Connection;
import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ladder.structure.connection.Connection.CONNECTED_BRIDGE;
import static ladder.structure.connection.Connection.NOT_CONNECTED_BRIDGE;
import static ladder.structure.connection.result.Point.MOVE_RIGHT;

public class Points {
    private final List<Point> points;

    public Points(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.points = IntStream.rangeClosed(0, ladderWidth).boxed()
                .map(Point::of)
                .collect(toList());
        movePoint(connectionStrategy);
    }

    private Points(List<Point> points, ConnectionStrategy connectionStrategy) {
        this.points = points;
        movePoint(connectionStrategy);
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
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            connections.add(NOT_CONNECTED_BRIDGE);
        }

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getDirection() == MOVE_RIGHT) {
                connections.set(points.get(i).value(), CONNECTED_BRIDGE);
            }
        }
        return Collections.unmodifiableList(connections);
    }

    private List<Point> movePoint(ConnectionStrategy connectionStrategy) {
        List<Connection> connections = addConnections(points.size() - 1, connectionStrategy);
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move(connections);
            pointsAfterConnection.add(after);
        }
        return pointsAfterConnection;
    }

    public Points getNext(ConnectionStrategy connectionStrategy) {
        return new Points(Collections.unmodifiableList(movePoint(connectionStrategy)), connectionStrategy);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
