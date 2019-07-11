package ladder.domain;

public class Direction_old {
    private final boolean left;
    private final boolean right;

    private Direction_old(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("정상적인 사다리가 아닙니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction_old first(boolean right) {
        return of(false, right);
    }

    public static Direction_old last(boolean left) {
        return of(left, false);
    }

    public static Direction_old of(boolean left, boolean right) {
        return new Direction_old(left, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

}
