package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bridge> bridges;

    public Line(int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        List<Bridge> bridges = BridgeGenerator.generate(numberOfPlayer, connectGenerator);
        validateBridges(bridges);
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public List<Boolean> getLineStates() {
        return bridges.stream()
                .map(this::bridgeTypeTobool)
                .limit(bridges.size() - 1)
                .collect(Collectors.toList());
    }

    private boolean bridgeTypeTobool(Bridge bridge) {
        if (bridge.getBridgeType() == BridgeType.RIGHT) {
            return true;
        }

        return false;
    }

    private void validateBridges(List<Bridge> bridges) {
        for (int current = 0; current < bridges.size() - 1; current++) {
            validateContinuous(bridges.get(current), bridges.get(current + 1));
        }
    }

    private void validateContinuous(Bridge current, Bridge next) {
        if (current.isConnected() && Bridge.isSameBridgeType(current, next)) {
            throw new IllegalStateException("연속된 연결 다리가 존재합니다.");
        }
    }

}
