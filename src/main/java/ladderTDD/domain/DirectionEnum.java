package ladderTDD.domain;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum DirectionEnum {
    SYAY(FALSE, FALSE),
    LEFT(TRUE, FALSE),
    RIGHT(FALSE, TRUE),
    ALLTRUE(TRUE, TRUE);

    private boolean left;
    private boolean right;

    DirectionEnum(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static DirectionEnum valueOf(boolean left, boolean right) {
        return Arrays.stream(DirectionEnum.values())
                .filter(directionEnum -> directionEnum.equals(left, right))
                .findAny()
                .orElse(ALLTRUE);
    }

    public boolean equals(boolean left, boolean right) {
        if (this.left == left && this.right == right) {
            return true;
        }
        return false;
    }
}
