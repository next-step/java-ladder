package ladder.domain;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(FALSE, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
