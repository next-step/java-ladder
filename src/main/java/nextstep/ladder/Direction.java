package nextstep.ladder;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
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
