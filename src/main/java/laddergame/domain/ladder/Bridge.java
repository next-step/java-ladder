package laddergame.domain.ladder;

public class Bridge {
    private final BridgeType bridgeType;

    private Bridge(BridgeType bridgeType) {
        this.bridgeType = bridgeType;
    }

    public static Bridge createFirstBridge(boolean isConnected) {
        if (isConnected) {
            return createRightBridge();
        }

        return createNotLinkedBridge();
    }

    public static Bridge createNextBridge(boolean isConnected, Bridge beforeBridge) {
        if (beforeBridge.bridgeType.isRightConnected()) {
            return createLeftBridge();
        }

        if (isConnected) {
            return createRightBridge();
        }

        return createNotLinkedBridge();
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
        return before.getBridgeType().equals(next.getBridgeType());
    }

    public BridgeType getBridgeType() {
        return bridgeType;
    }
}
