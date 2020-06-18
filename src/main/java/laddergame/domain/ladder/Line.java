package laddergame.domain.ladder;

import laddergame.domain.player.Position;
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

    public Position movePosition(Position position) {
        Bridge findBridge = bridges.stream()
                .filter(bridge -> bridge.isBridgeColumn(position.column()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return findBridge.movePositionColumn(position).moveDown();
    }

    public boolean isSameHeight(Position position) {
        return lineHeight.equals(position.height());
    }
}
