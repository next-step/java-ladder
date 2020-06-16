package laddergame.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Bridge> bridges;

    public Line(int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        this.bridges = BridgeGenerator.generate(numberOfPlayer, connectGenerator);
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    public List<Boolean> getLineStates() {
        return bridges.stream()
                .map(Bridge::isConnected)
                .collect(Collectors.toList());
    }
}
