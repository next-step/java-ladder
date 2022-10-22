package laddergame.domain;

import java.util.List;
import java.util.Objects;

public class LadderLine {

    private final List<Boolean> connections;

    public LadderLine(List<Boolean> connections) {
        validate(connections);
        this.connections = connections;
    }

    private void validate(List<Boolean> connections) {
        boolean previousConnected = false;
        for (boolean currentConnected : connections) {
            validateContinuousConnection(currentConnected, previousConnected);
            previousConnected = currentConnected;
        }
    }

    private void validateContinuousConnection(boolean currentConnected, boolean previousConnected) {
        if (previousConnected && currentConnected) {
            throw new IllegalArgumentException("가로 라인은 연속으로 연결될 수 없습니다.");
        }
    }

    public int size() {
        return connections.size();
    }

    public LadderConnectedDirection getConnectedDirection(int indexOfPosition) {
        return LadderConnectedDirection.of(isConnectedRight(indexOfPosition), isConnectedLeft(indexOfPosition));
    }

    private boolean isConnectedRight(int indexOfPosition) {
        return indexOfPosition < size() && isConnected(indexOfPosition);
    }

    private boolean isConnectedLeft(int indexOfPosition) {
        return indexOfPosition > 0 && isConnected(indexOfPosition - 1);

    }

    public boolean isConnected(int index) {
        return connections.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }

    @Override
    public String toString() {
        return "LadderLineConnections{" +
                "connections=" + connections +
                '}';
    }

}
