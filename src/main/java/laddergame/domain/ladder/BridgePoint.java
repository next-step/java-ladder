package laddergame.domain.ladder;

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

    private boolean isLeftColumn(final int targetColumn) {
        return left == targetColumn;
    }

    private boolean isRightColumn(final int targetColumn) {
        return right == targetColumn;
    }
}
