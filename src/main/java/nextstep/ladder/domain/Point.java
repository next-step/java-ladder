package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("좌 우 모두 이동 가능한 Point 생성 불가");
        }
    }

    public static Point createLeftmost(boolean canMoveRight) {
        return new Point(false, canMoveRight);
    }

    public Point createRightmost() {
        return new Point(this.right, false);
    }

    public Point createNext(boolean canMoveRight) {
        return new Point(this.right, !this.right && canMoveRight);
    }

    public boolean canMoveLeft() {
        return left;
    }

    public boolean canMoveRight() {
        return right;
    }
}
