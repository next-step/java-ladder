package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class BridgeLines {

    private static final int MINIMUM_BRIDGE_LINES_SIZE = 2;

    private final List<BridgeLine> bridgeLines;

    public BridgeLines(final List<BridgeLine> bridgeLines) {
        validateBridgeLinesOrThrow(bridgeLines);

        this.bridgeLines = bridgeLines;
    }

    public int size() {
        return this.bridgeLines.size();
    }

    public List<BridgeLine> getBridgeLines() {
        return bridgeLines;
    }

    private void validateBridgeLinesOrThrow(final List<BridgeLine> bridgeLines) {
        validateBridgeLinesSize(bridgeLines);
        validateBridgeLinesHeightOrThrow(bridgeLines);
        validateContinuousBridgeLinesOrThrow(bridgeLines);
    }

    private void validateBridgeLinesSize(final List<BridgeLine> bridgeLines) {
        if (bridgeLines.size() < MINIMUM_BRIDGE_LINES_SIZE) {
            throw new IllegalArgumentException("사다리 다리 라인은 최소 2개 이상이여야 합니다.");
        }
    }

    private void validateBridgeLinesHeightOrThrow(final List<BridgeLine> bridgeLines) {
        if (bridgeLines.stream()
                       .map(BridgeLine::getHeight)
                       .distinct()
                       .count() != 1) {
            throw new IllegalArgumentException("사다리 다리 라인들의 높이는 동일해야 합니다.");
        }
    }

    private void validateContinuousBridgeLinesOrThrow(final List<BridgeLine> bridgeLines) {
        IntStream.range(0, bridgeLines.size() - 1)
                 .filter(index -> {
                     final BridgeLine current = bridgeLines.get(index);
                     final BridgeLine next = bridgeLines.get(index + 1);

                     return current.hasSameHeightConnection(next);
                 })
                 .findFirst()
                 .ifPresent(ignore -> {
                     throw new IllegalArgumentException("사다리 다리 연결이 연속될 수 없습니다.");
                 });
    }
}
