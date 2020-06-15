package laddergame.domain.ladder;

import java.util.Objects;

public class Bridge {
    private final boolean connection;
    private final BridgePoint bridgePoint;

    public Bridge(final boolean isConnected, final int leftColumn) {
        this.connection = isConnected;
        this.bridgePoint = new BridgePoint(leftColumn);
    }

    public static Bridge createBridge(final boolean isConnected, final int leftColumn) {
        return new Bridge(isConnected, leftColumn);
    }

    public static Bridge createNextBridge(final boolean isConnected, final Bridge before) {
        if (before.isConnected()) {
            return new Bridge(false, before.getRightColumn());
        }

        return new Bridge(isConnected, before.getRightColumn());
    }

    public static boolean isContinuousBridge(Bridge before, Bridge next) {
        if (before.getRightColumn() != next.getLeftColumn()) {
            return false;
        }

        if (before.isConnected() && next.isConnected()) {
            return true;
        }

        return false;
    }

    public int getLeftColumn() {
        return bridgePoint.getLeft();
    }

    public int getRightColumn() {
        return bridgePoint.getRight();
    }

    public boolean isConnected() {
        return connection;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Bridge)) return false;
        Bridge bridge = (Bridge) o;
        return connection == bridge.connection &&
                bridgePoint.equals(bridge.bridgePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, bridgePoint);
    }
}
