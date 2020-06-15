package laddergame.domain.ladder;

import java.util.Objects;

public class Bridge {
    private static final int MIN_COLUMN = 1;
    private final int column;
    private final BridgeType bridgeType;

    private Bridge(BridgeType bridgeType, int column) {
        validateBridgeColumn(column);
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

    private void validateBridgeColumn(int column) {
        if (column < MIN_COLUMN) {
            throw new IllegalArgumentException("열 번호는 1 이상이어야 합니다. - " + column);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Bridge)) return false;
        Bridge bridge = (Bridge) o;
        return column == bridge.column &&
                getBridgeType() == bridge.getBridgeType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, getBridgeType());
    }
}
