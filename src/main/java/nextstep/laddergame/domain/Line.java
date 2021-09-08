package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private static final int FIRST_POSITION = 0;

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

    public int move(int position) {
        validatePositionRange(position);
        if (isLastPosition(position)) {
            return leftConnectionOf(position).move(position, Direction.RIGHT);
        }
        if (position == FIRST_POSITION || rightConnectionOf(position).isConnected()) {
            return rightConnectionOf(position).move(position, Direction.LEFT);
        }
        return leftConnectionOf(position).move(position, Direction.RIGHT);
    }

    private boolean isLastPosition(int position) {
        return position == connections.size();
    }

    private LineConnection rightConnectionOf(int position) {
        return connections.get(position);
    }

    private LineConnection leftConnectionOf(int position) {
        return connections.get(position - 1);
    }

    private void validatePositionRange(int position) {
        if (position < FIRST_POSITION || position > connections.size()) {
            throw new IllegalArgumentException(String.format("포지션 값이 유효하지 않습니다. position: %s", position));
        }
    }
}
