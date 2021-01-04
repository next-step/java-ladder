package ladder.domain;

import ladder.util.ErrorMessage;

public class LadderDirection {

    private boolean left;
    private boolean right;
    private static int MOVE_DISTANCE = 1;

    public LadderDirection(final boolean left, final boolean right) {
        checkValue(left, right);
        this.left = left;
        this.right = right;
    }

    public int moveDistance() {
        if (this.left) {
            return -MOVE_DISTANCE;
        }

        if (this.right) {
            return MOVE_DISTANCE;
        }

        return 0;
    }

    private void checkValue(final boolean left, final boolean right) {
        if (left && right) {
            throw new RuntimeException(ErrorMessage.getCheckDirection());
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "LadderDirection{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
