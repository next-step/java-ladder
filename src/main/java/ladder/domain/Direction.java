package ladder.domain;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public int move(int index) {
        if (isLeft()) {
            return index - 1;
        }

        if (isRight()) {
            return index + 1;
        }

        return index;
    }

}
