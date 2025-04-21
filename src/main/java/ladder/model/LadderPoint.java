package ladder.model;

import java.util.Objects;

public class LadderPoint {
    private final boolean leftSide;
    private final boolean rightSide;

    private LadderPoint(boolean leftSide, boolean rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;

        if (leftSide && rightSide) {
            throw new IllegalArgumentException("왼쪽과 오른쪽 모두 true일 수 없습니다.");
        }
    }

    public static LadderPoint of(boolean leftSide, boolean rightSide) {
        return new LadderPoint(leftSide, rightSide);
    }

    public static LadderPoint first(boolean rightSide) {
        return new LadderPoint(false, rightSide);
    }

    public LadderPoint next(boolean rightSide) {
        return new LadderPoint(this.rightSide, rightSide);
    }

    public LadderPoint last() {
        return new LadderPoint(this.rightSide, false);
    }

    public LadderDirection move() {
        if (leftSide) {
            return LadderDirection.LEFT;
        }
        if (rightSide) {
            return LadderDirection.RIGHT;
        }
        return LadderDirection.STAY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderPoint)) return false;
        LadderPoint that = (LadderPoint) o;
        return leftSide == that.leftSide && rightSide == that.rightSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftSide, rightSide);
    }
}
