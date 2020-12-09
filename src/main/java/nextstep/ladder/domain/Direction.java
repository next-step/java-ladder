package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;

public enum Direction {

    LEFT(true, false),
    NONE(false, false),
    RIGHT(false, true);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }


    public static Direction of(boolean left, boolean right) {
        return Arrays.stream(values())
                .filter(item -> item.left == left)
                .filter(item -> item.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION));
    }

    public static Direction of(Direction leftDirection, boolean right) {
        return Direction.of(leftDirection.right, right);
    }

    public boolean isRight() {
        return right;
    }

}
