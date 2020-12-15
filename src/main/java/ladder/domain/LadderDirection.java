package ladder.domain;

import ladder.util.ErrorMessage;

public class LadderDirection {
    private boolean left;
    private boolean right;

    public LadderDirection(final boolean left, final boolean right) {
        checkValue(left, right);
        this.left = left;
        this.right = right;
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.right) {
            return 1;
        }

        return 0;
    }

    private void checkValue(final boolean left, final boolean right) {
        if (left && right) {
            throw new RuntimeException(ErrorMessage.getCheckDirection());
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public String toString() {
        return "LadderDirection{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
