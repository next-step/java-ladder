package nextstep.step4.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 12:54
 */
public class Direction {
    private static final String CREATE_SAME_STATUS_EXCEPTION_MESSAGE = "현재 Link와 Left Link가 모두 true면 안됩니다.";
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int PASS = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (right && left) {
            throw new IllegalArgumentException(CREATE_SAME_STATUS_EXCEPTION_MESSAGE);
        }
        this.right = right;
        this.left = left;
    }

    public boolean moveDirectionLeft() {
        return left && !right ? true : false;
    }

    public boolean moveDirectionRight() {
        return !left && right ? true : false;
    }

    public Direction next(boolean random) {
        if (right) {
            return new Direction(right, false);
        }
        return new Direction(right, random);
    }

    public int move() {
        if (!left && !right) {
            return PASS;
        }
        return checkLineMove();
    }

    private int checkLineMove() {
        if (right && !left) {
            return RIGHT;
        }
        return LEFT;
    }
}
