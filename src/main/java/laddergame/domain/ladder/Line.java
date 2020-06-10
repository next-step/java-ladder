package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(int numberOfPlayer, BridgeGenerator bridgeGenerator) {
        List<Bridge> bridges = bridgeGenerator.generate(numberOfPlayer);
        validateBridges(bridges);
        this.bridges = bridges;
    }

    public List<Bridge> getLine() {
        return Collections.unmodifiableList(bridges);
    }

    private void validateBridges(List<Bridge> bridges) {
        for (int current = 0; current < bridges.size() - 1; current++) {
            validateContinuous(bridges.get(current), bridges.get(current + 1));
        }
    }

    private void validateContinuous(Bridge current, Bridge next) {
        if (current.isConnected() && next.isConnected()) {
            throw new IllegalStateException("연속된 연결 다리가 존재합니다.");
        }
    }

}
