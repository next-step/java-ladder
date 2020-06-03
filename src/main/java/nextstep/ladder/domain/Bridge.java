package nextstep.ladder.domain;

public class Bridge {
    private final boolean cross;

    public Bridge(boolean cross) {
        this.cross = cross;
    }

    public boolean isCross() {
        return this.cross;
    }

    public static Bridge next(Bridge prevBridge, BridgeGenerator bridgeGenerator) {
        if (prevBridge.isCross()) {
            return new Bridge(false);
        }
        return new Bridge(bridgeGenerator.isCrossBridge());
    }
}
