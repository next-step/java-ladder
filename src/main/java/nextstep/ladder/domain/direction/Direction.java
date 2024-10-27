package nextstep.ladder.domain.direction;

import java.util.function.IntUnaryOperator;

public enum Direction {
    DOWN(x -> x),
    RIGHT_DOWN(x -> x + 1),
    LEFT_DOWN(x -> x - 1);

    private final IntUnaryOperator xMover;
    private final IntUnaryOperator yMover;

    Direction(IntUnaryOperator xMover) {
        this.xMover = xMover;
        this.yMover = y -> y + 1;
    }

    public int moveX(int x) {
        int after = xMover.applyAsInt(x);

        if (after < 0 ) {
            throw new IllegalArgumentException("0보다 작은 곳으로 이동할 수 없습니다.");
        }
        return xMover.applyAsInt(x);
    }

    public int moveY(int y) {
        return yMover.applyAsInt(y);
    }
}
