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

    public boolean isBridgeColumn(final Column targetColumn) {
        if (isLeftColumn(targetColumn) || isRightColumn(targetColumn)) {
            return true;
        }

        return false;
    }

    public Column getLeft() {
        return left;
    }

    public Column getRight() {
        return right;
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
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight());
    }
}
