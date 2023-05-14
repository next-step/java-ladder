package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Connections {
    private static final int START_INDEX_OF_CONNECTIONS = 0;
    private static final int ONE = 1;
    private final List<Connection> connections;

    public Connections(List<Connection> connections) {
        validateConnections(connections);
        this.connections = connections;
    }

    public List<Connection> connections() {
        return Collections.unmodifiableList(connections);
    }

    private void validateConnections(List<Connection> connections) {
        if(connections == null) {
            throw new IllegalArgumentException("가로 라인의 연결선은 null이 될 수 없습니다.");
        }

        if(containsConsecutiveConnections(connections)) {
            throw new IllegalArgumentException("가로 라인의 연결선은 연속해서 존재할 수 없습니다.");
        }
    }

    private boolean containsConsecutiveConnections(List<Connection> connections) {
        return IntStream.range(START_INDEX_OF_CONNECTIONS, beforeLastIndexOf(connections))
                .anyMatch(index -> isConsecutiveConnections(connections, index));
    }

    private int beforeLastIndexOf(List<Connection> connections) {
        return connections.size() - ONE;
    }

    private boolean isConsecutiveConnections(List<Connection> connections, int index) {
        return connections.get(index).isConnected() && connections.get(index + ONE).isConnected();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connections)) return false;
        Connections that = (Connections) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
