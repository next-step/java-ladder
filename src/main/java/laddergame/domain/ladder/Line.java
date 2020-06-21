package laddergame.domain.ladder;

import laddergame.domain.vo.Position;
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
        Bridge findBridge = findBridge(position);

        return findBridge.movePositionColumn(position).moveDown();
    }

    private Bridge findBridge(Position position) {
        List<Bridge> findBridges = bridges.stream()
                .filter(bridge -> bridge.isBridgeColumn(position.getColumn()))
                .collect(Collectors.toList());

        if (findBridges.isEmpty()) {
            throw new IllegalArgumentException("현재 위치 열 번호에 맞는 Bridge를 찾을 수 없습니다. - " + position.getColumn().toInt());
        }

        return findBridges.stream()
                .filter(Bridge::isConnected)
                .findFirst()
                .orElse(findBridges.get(0));
    }

    public boolean isSameHeight(Position position) {
        return lineHeight.equals(position.getHeight());
    }

    public Height getLineHeight() {
        return lineHeight;
    }
}
