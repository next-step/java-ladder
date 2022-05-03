package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final Bridge bridge;

    Line(List<Boolean> bridges) {
        this.bridge = new Bridge(bridges);
    }

    static Line ofWidth(int width) {
        return new Line(BridgeFactory.createBridgeOfWidth(width));
    }

    public void apply(Participants participants) {
        bridge.apply(participants);
    }

    public List<Boolean> getBridges() {
        return bridge.getBridges();
    }
}
