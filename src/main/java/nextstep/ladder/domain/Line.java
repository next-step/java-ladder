package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Bridge> bridges = new ArrayList<>();

    public Line(int countOfPerson, BridgeGenerator bridgeGenerator) {
        this.generatePositions(countOfPerson, bridgeGenerator);
    }

    private void generatePositions(int countOfPerson, BridgeGenerator bridgeGenerator) {
        this.bridges.add(new Bridge(bridgeGenerator.isCrossBridge()));
        for (int i = 1; i < countOfPerson - 1; i++) {
            Bridge prevBridge = this.bridges.get(i - 1);
            Bridge currentBridge = Bridge.next(prevBridge, bridgeGenerator);
            this.bridges.add(currentBridge);
        }
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(this.bridges);
    }
}
