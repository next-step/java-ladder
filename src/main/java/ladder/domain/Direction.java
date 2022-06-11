package ladder.domain;

import ladder.exception.InvalidDirectionException;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validDirection(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidDirectionException();
        }
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
