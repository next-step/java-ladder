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
    public static final int PASS = 0;
    public static final int INCREASE = 1;
    public static final int DECREASE = -1;

    private final boolean right;
    private final boolean left;

    public Direction(boolean right, boolean left) {
        if (right && left) {
            throw new IllegalArgumentException(CREATE_SAME_STATUS_EXCEPTION_MESSAGE);
        }
        this.right = right;
        this.left = left;
    }

    public int move() {
        if (right) {
            return INCREASE;
        }
        if (left) {
            return DECREASE;
        }
        return PASS;
    }

    public boolean current() {
        return right;
    }

    public boolean left() {
        return left;
    }
}
