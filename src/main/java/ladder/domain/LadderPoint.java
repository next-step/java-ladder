package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderPoint {
    private final int x;
    private final int y;

    public LadderPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public LadderPoint(int x) {
        this(x, 0);
    }

    public LadderPoint move(LadderLine ladderLine) {
        MoveDirection moveDirection = ladderLine.moveDirection(x);
        if (moveDirection == MoveDirection.LEFT) {
            return new LadderPoint(x - 1, y + 1);
        }
        if (moveDirection == MoveDirection.RIGHT) {
            return new LadderPoint(x + 1, y + 1);
        }
        return new LadderPoint(x, y + 1);
    }

    public Prize prize(List<Prize> prizes) {
        return prizes.get(x);
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        LadderPoint that = (LadderPoint) compareValue;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
