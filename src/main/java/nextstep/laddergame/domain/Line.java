package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<LineConnection> connections;

    private Line(List<LineConnection> connections) {
        validateNotConnectedInSeries(connections);
        this.connections = Collections.unmodifiableList(connections);
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
        return connections;
    }
}
