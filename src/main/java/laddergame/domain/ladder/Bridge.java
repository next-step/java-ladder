package laddergame.domain.ladder;

public class Bridge {
    private final BridgeType bridgeType;

    private Bridge(boolean isConnected) {
        this.bridgeType = BridgeType.findType(isConnected);
    }

    public static Bridge createFirstBrige(boolean isConnected) {
        return new Bridge(isConnected);
    }

    public static Bridge createNextBridge(boolean isConnected, Bridge beforeBridge) {
        if (isContinuousBridge(isConnected, beforeBridge)) {
            return new Bridge(!isConnected);
        }

        return new Bridge(isConnected);
    }

    private static boolean isContinuousBridge(boolean isConnected, Bridge beforeBridge) {
        if (beforeBridge.bridgeType.isConnected() && isConnected) {
            return true;
        }

        return false;
    }

    public boolean isConnected() {
        return bridgeType.isConnected();
    }
}
