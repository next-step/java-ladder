package nextstep.step4.ladder.domain;

import nextstep.step4.ladder.domain.enums.Move;

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

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (right && left) {
            throw new IllegalArgumentException(CREATE_SAME_STATUS_EXCEPTION_MESSAGE);
        }
        this.right = right;
        this.left = left;
    }

    public int move() {
        return Move.getDirection(left, right);
    }

    public boolean current() {
        return right;
    }

    public boolean left() {
        return left;
    }
}
