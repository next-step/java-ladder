package ladder.model;

import ladder.exception.CannotCreateLadderException;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new CannotCreateLadderException("[사다리 생성 에러] 사다리의 가로 라인이 겹칠 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public boolean isConnected() {
        return this.right;
    }

    public boolean isConnectableNext() {
        return !this.right;
    }

    private static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next() {
        if (this.right) {
            return of(true, false);
        }

        return of(false, false);
    }

    public Direction next(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }
}
