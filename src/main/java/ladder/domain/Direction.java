package ladder.domain;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향은 왼쪽과 오른쪽이 동시에 존재 할 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Direction next() {
        return new Direction(this.right, FALSE);
    }

    public Direction next(boolean right) {
        return new Direction(this.right, right);
    }
}
