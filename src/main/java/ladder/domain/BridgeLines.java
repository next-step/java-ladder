package ladder.domain;

import ladder.exception.BridgeLinesDifferenceHeightException;
import ladder.exception.ContinuousBridgeLinesException;
import ladder.exception.InvalidBridgeLinesSizeException;

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
            throw new InvalidBridgeLinesSizeException();
        }
    }

    private void validateBridgeLinesHeightOrThrow(final List<BridgeLine> bridgeLines) {
        if (bridgeLines.stream()
                       .map(BridgeLine::getHeight)
                       .distinct()
                       .count() != 1) {
            throw new BridgeLinesDifferenceHeightException();
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
                     throw new ContinuousBridgeLinesException();
                 });
    }
}
