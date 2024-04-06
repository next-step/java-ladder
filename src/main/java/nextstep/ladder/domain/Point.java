package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("좌 우 모두 이동 가능한 Point 생성 불가");
        }
        this.left = left;
        this.right = right;
    }

    public static Point leftmostPoint(boolean rightMoveable) {
        return new Point(false, rightMoveable);
    }

    public static Point rightmostPoint(boolean leftMoveable) {
        return new Point(leftMoveable, false);
    }

    public boolean canMoveLeft() {
        return left;
    }

    public boolean canMoveRight() {
        return right;
    }
}
