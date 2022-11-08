package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> connections;

    public Line(final List<Boolean> connections) {
        validateSizeOrThrow(connections);
        validateContinuousConnectionsOrThrow(connections);

        this.connections = connections;
    }

    public int size() {
        return this.connections.size();
    }

    public boolean isConnected(final int index) {
        return this.connections.get(index);
    }

    private void validateSizeOrThrow(final List<Boolean> connections) {
        if (Objects.isNull(connections) || connections.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인은 최소 1개 이상의 연결 정보를 가져야합니다.");
        }
    }

    private void validateContinuousConnectionsOrThrow(final List<Boolean> connections) {
        if (connections.size() == 1) {
            return;
        }

        IntStream.range(1, connections.size())
                 .filter(index -> connections.get(index - 1) && connections.get(index))
                 .findAny()
                 .ifPresent(index -> {
                     throw new IllegalArgumentException("2개 이상의 연결된 다리는 가질 수 없습니다.");
                 });
    }
}
