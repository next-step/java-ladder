package nextstep.ladder.domain.line;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.bridge.Bridge;
import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.domain.bridge.Bridges;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final Bridges bridges;

    public Line(int countOfPerson, BridgeGenerator bridgeGenerator) {
        bridges = new Bridges(this.generatePositions(countOfPerson, bridgeGenerator));
    }

    private List<Bridge> generatePositions(int countOfPerson, BridgeGenerator bridgeGenerator) {
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(new Bridge(bridgeGenerator.isCrossBridge(), 0));
        for (int i = 1; i < countOfPerson - 1; i++) {
            Bridge prevBridge = bridges.get(i - 1);
            Bridge currentBridge = Bridge.next(prevBridge, bridgeGenerator, i);
            bridges.add(currentBridge);
        }
        return bridges;
    }

    public List<Bridge> getBridges() {
        return this.bridges.getBridges();
    }

    public Position move(Position position) {
        return bridges.movePosition(position);
    }
}
