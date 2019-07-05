package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("정상적인 사다리가 아닙니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public static Direction last(boolean left) {
        return of(left, false);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

}
