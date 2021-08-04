package ladder.domain;

import java.util.List;

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

    public LadderPoint() {
        this(0, 0);
    }

    public LadderPoint move(LadderLine ladderLine) {
        MoveDirection moveDirection = ladderLine.moveDirection(x);
        if (moveDirection == MoveDirection.LEFT) {
            return new LadderPoint(x - 1, y + 1);
        }
        if (moveDirection == MoveDirection.RIGHT) {
            return new LadderPoint(x + 1, y + 1);
        }
        return this;
    }

    public Prize prize(List<Prize> prizes) {
        return prizes.get(x);
    }
}
