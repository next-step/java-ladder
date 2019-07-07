package nextstep.step4.ladder.domain.enums;

import java.util.Arrays;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-07 22:37
 */
public enum Move {
    RIGHT(false, true, 1),
    LEFT(true, false, -1),
    PASS(false, false, 0);

    private final boolean left;
    private final boolean right;
    private final int direction;

    Move(boolean left, boolean right, int direction) {
        this.left = left;
        this.right = right;
        this.direction = direction;
    }

    public static int getDirection(boolean left, boolean right) {
        Move direction = Arrays.stream(Move.values())
                .filter(move -> move.left == left && move.right == right)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return direction.direction;
    }
}
