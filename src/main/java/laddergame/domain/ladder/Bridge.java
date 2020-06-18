package laddergame.domain.ladder;

import laddergame.domain.vo.Position;
import laddergame.domain.vo.Column;

import java.util.Objects;

public class Bridge {
    private final boolean connection;
    private final BridgePoint bridgePoint;

    public Bridge(final boolean isConnected, final int leftColumn) {
        this.connection = isConnected;
        this.bridgePoint = new BridgePoint(leftColumn);
    }

    public Bridge createNextBridge(final boolean connection) {
        if (isConnected()) {
            return new Bridge(false, getRightColumn());
        }

        return new Bridge(connection, getRightColumn());
    }

    public int getRightColumn() {
        return bridgePoint.getRight();
    }

    public boolean isConnected() {
        return connection;
    }

    public Position movePositionColumn(Position position) {
        if (!connection) {
            return position;
        }
        if (bridgePoint.isLeftColumn(position.getColumn())) {
            return position.moveRight();
        }

        return position.moveLeft();
    }

    public boolean isBridgeColumn(Column column) {
        return bridgePoint.isBridgeColumn(column.toInt());
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
