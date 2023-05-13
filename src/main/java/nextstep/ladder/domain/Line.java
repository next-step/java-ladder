package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int START_INDEX_OF_CONNECTIONS = 0;
    private List<Boolean> connections;

    public Line(List<Boolean> connections) {
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
        return connections.size() - 1;
    }

    private boolean isConsecutiveConnections(List<Boolean> connections, int index) {
        return connections.get(index) && connections.get(index + 1);
    }
}
