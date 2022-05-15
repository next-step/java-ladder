package nextstep.ladder.domain;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
