package laddergame.domain.ladder;

public class Bridge {
    private final int column;
    private final BridgeType bridgeType;

    private Bridge(BridgeType bridgeType, int column) {
        this.bridgeType = bridgeType;
        this.column = column;
    }

    public static Bridge createNotLinkedBridge(int column) {
        return new Bridge(BridgeType.NONE, column);
    }

    public static Bridge createLeftBridge(int column) {
        return new Bridge(BridgeType.LEFT, column);
    }

    public static Bridge createRightBridge(int column) {
        return new Bridge(BridgeType.RIGHT, column);
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

    public static Bridge createBridge(boolean connected, int column) {
        if (connected) {
            return new Bridge(BridgeType.RIGHT, column);
        }

        return new Bridge(BridgeType.NONE, column);
    }

    public Bridge createNext(boolean connected) {
        if (this.bridgeType == BridgeType.RIGHT) {
            return new Bridge(BridgeType.LEFT, column + 1);
        }

        return createBridge(connected, column + 1);
    }

    public Bridge createLast() {
        if (this.getBridgeType() == BridgeType.RIGHT) {
            return new Bridge(BridgeType.LEFT, column + 1);
        }

        return new Bridge(BridgeType.NONE, column + 1);
    }
}
