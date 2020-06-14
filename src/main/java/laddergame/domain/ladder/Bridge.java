package laddergame.domain.ladder;

public class Bridge {
    private final BridgeType bridgeType;

    private Bridge(BridgeType bridgeType) {
        this.bridgeType = bridgeType;
    }

    public static Bridge createNotLinkedBridge() {
        return new Bridge(BridgeType.NONE);
    }

    public static Bridge createLeftBridge() {
        return new Bridge(BridgeType.LEFT);
    }

    public static Bridge createRightBridge() {
        return new Bridge(BridgeType.RIGHT);
    }

    public boolean isConnected() {
        return bridgeType.isConnected();
    }

    public static boolean isSameBridgeType(Bridge before, Bridge next) {
        return before.getBridgeType() == next.getBridgeType();
    }

    public BridgeType getBridgeType() {
        return bridgeType;
    }

    public static Bridge createBridge(boolean connected) {
        if (connected) {
            return new Bridge(BridgeType.RIGHT);
        }

        return new Bridge(BridgeType.NONE);
    }

    public Bridge createNext(boolean connected) {
        if (this.bridgeType == BridgeType.RIGHT) {
            return new Bridge(BridgeType.LEFT);
        }

        return createBridge(connected);
    }

    public Bridge createLast() {
        if (this.getBridgeType() == BridgeType.RIGHT) {
            return new Bridge(BridgeType.LEFT);
        }

        return new Bridge(BridgeType.NONE);
    }
}
