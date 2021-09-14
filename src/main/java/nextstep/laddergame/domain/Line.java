package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<LineConnection> connections;
    private final List<Point> points;

    private Line(List<LineConnection> connections) {
        validateNotConnectedInSeries(connections);
        this.connections = connections;
        this.points = Point.listOf(connections);
    }

    private void validateNotConnectedInSeries(List<LineConnection> connections) {
        connections.stream()
                .reduce(this::validateNotConnectedInSeries);
    }

    private LineConnection validateNotConnectedInSeries(LineConnection previousConnection, LineConnection currentConnection) {
        if (previousConnection.isConnected() && currentConnection.isConnected()) {
            throw new IllegalArgumentException("연속으로 연결된 포인트가 존재합니다.");
        }
        return currentConnection;
    }

    public static Line of(LineConnectStrategy lineConnectStrategy) {
        return new Line(lineConnectStrategy.getLineConnections());
    }

    public List<LineConnection> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public int move(int index) {
        validatePositionRange(index);
        return points.get(index).move();
    }

    private void validatePositionRange(int index) {
        if (index < 0 || points.size() <= index) {
            throw new IllegalArgumentException(String.format("포인트가 존재하지 않습니다. index: %s", index));
        }
    }
}
