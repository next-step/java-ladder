package laddergame.domain.ladder;

import laddergame.domain.vo.Height;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final Height lineHeight;
    private final List<Bridge> bridges;

    public Line(int lineHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        this.lineHeight = new Height(lineHeight);
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
