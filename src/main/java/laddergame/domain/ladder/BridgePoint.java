package laddergame.domain.ladder;

import java.util.Objects;

public class BridgePoint {
    private static final int MIN_BRIDGE_INDEX = 1;
    private final int left;
    private final int right;

    public BridgePoint(final int leftIndex) {
        validateBridgePointIndex(leftIndex);
        this.left = leftIndex;
        this.right = leftIndex + 1;
    }

    private void validateBridgePointIndex(final int leftIndex) {
        if (leftIndex < MIN_BRIDGE_INDEX) {
            throw new IllegalArgumentException("Bridge 연결 Index는 1보다 작을 수 없습니다. - " + leftIndex);
        }
    }

    public boolean isBridgeColumn(final int targetColumn) {
        if (isLeftColumn(targetColumn) || isRightColumn(targetColumn)) {
            return true;
        }

        return false;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    private boolean isLeftColumn(final int targetColumn) {
        return left == targetColumn;
    }

    private boolean isRightColumn(final int targetColumn) {
        return right == targetColumn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BridgePoint)) return false;
        BridgePoint that = (BridgePoint) o;
        return getLeft() == that.getLeft() &&
                getRight() == that.getRight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight());
    }
}
