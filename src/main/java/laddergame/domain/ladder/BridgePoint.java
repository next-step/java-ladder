package laddergame.domain.ladder;

import laddergame.domain.vo.Column;

import java.util.Objects;

public class BridgePoint {
    private final Column left;
    private final Column right;

    public BridgePoint(final int leftColumn) {
        this.left = new Column(leftColumn);
        this.right = new Column(leftColumn + 1);
    }

    public boolean isBridgeColumn(final int targetColumn) {
        Column target = new Column(targetColumn);
        if (isLeftColumn(target) || isRightColumn(target)) {
            return true;
        }

        return false;
    }

    public int getLeft() {
        return left.toInt();
    }

    public int getRight() {
        return right.toInt();
    }

    public boolean isLeftColumn(final Column targetColumn) {
        return left.equals(targetColumn);
    }

    public boolean isRightColumn(final Column targetColumn) {
        return right.equals(targetColumn);
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
