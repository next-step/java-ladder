package laddergame.domain.ladder;

public enum BridgeType {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean isConnected;

    BridgeType(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static BridgeType findType(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }

        return DISCONNECTED;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
