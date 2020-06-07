package nextstep.ladder.domain.bridge;

import nextstep.ladder.domain.Position;

public class Bridge {
    private final boolean cross;

    private final Position position;

    public Bridge(boolean cross, int position) {
        this.cross = cross;
        this.position = new Position(position);
    }

    public boolean isCross() {
        return this.cross;
    }

    public static Bridge next(Bridge prevBridge, BridgeGenerator bridgeGenerator, int position) {
        if (prevBridge.isCross()) {
            return new Bridge(false, position);
        }
        return new Bridge(bridgeGenerator.isCrossBridge(), position);
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("Bridge cross : %s, position : %s", this.cross, this.position);
    }
}
