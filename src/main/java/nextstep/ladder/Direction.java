package nextstep.ladder;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(); //todo: 예외 정의
        }
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public int move() {
        if (this.right) {
            return 1;
        }

        if (this.left) {
            return -1;
        }
        return 0;
    }
}
