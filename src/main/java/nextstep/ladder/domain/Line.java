package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(int countOfPerson, MovementGenerator movementGenerator) {
        this.bridges = this.generateBridges(countOfPerson, movementGenerator);
    }

    private List<Bridge> generateBridges(int countOfPerson, MovementGenerator movementGenerator) {
        List<Bridge> bridges = new ArrayList<>();
        Bridge bridge = Bridge.firstBridge(movementGenerator);
        bridges.add(bridge);
        for (int i = 1; i < countOfPerson - 1; i++) {
            bridge = Bridge.middleBridge(bridge, movementGenerator);
            bridges.add(bridge);
        }
        bridges.add(Bridge.lastBridge(bridge));
        return bridges;
    }

    public int move(int lineIndex) {
        return this.bridges.get(lineIndex).move();
    }

    public List<Bridge> getBridges() {
        return this.bridges;
    }

}
