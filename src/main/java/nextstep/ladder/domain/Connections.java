package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Connections {
    private static final int START_INDEX_OF_CONNECTIONS = 0;
    private static final int ONE = 1;
    private final List<Boolean> connections;

    public Connections(List<Boolean> connections) {
        validateConnections(connections);
        this.connections = connections;
    }

    private void validateConnections(List<Boolean> connections) {
        if(connections == null) {
            throw new IllegalArgumentException("가로 라인의 연결선은 null이 될 수 없습니다.");
        }

        if(containsConsecutiveConnections(connections)) {
            throw new IllegalArgumentException("가로 라인의 연결선은 연속해서 존재할 수 없습니다.");
        }
    }

    private boolean containsConsecutiveConnections(List<Boolean> connections) {
        return IntStream.range(START_INDEX_OF_CONNECTIONS, beforeLastIndexOf(connections))
                .anyMatch(index -> isConsecutiveConnections(connections, index));
    }

    private int beforeLastIndexOf(List<Boolean> connections) {
        return connections.size() - ONE;
    }

    private boolean isConsecutiveConnections(List<Boolean> connections, int index) {
        return connections.get(index) && connections.get(index + ONE);
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
