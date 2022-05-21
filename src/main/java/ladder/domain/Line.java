package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bridge> line;

    public Line(List<Bridge> bridges) {
        validateContinuousConnected(bridges);
        this.line = bridges;
    }

    private void validateContinuousConnected(List<Bridge> bridges) {
        IntStream
                .range(0, bridges.size() - 1)
                .filter(i -> isOverlap(bridges.get(i), bridges.get(i + 1)))
                .forEach(i -> {
                    throw new IllegalArgumentException("연속으로 연결 될 수 없습니다.");
                });
    }

    private boolean isOverlap(Bridge currentBridge, Bridge nextBridge) {
        return currentBridge.isConnected() && currentBridge.equals(nextBridge);
    }

    public List<Bridge> getLine() {
        return line;
    }
}

