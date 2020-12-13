package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;

public enum Direction {

    LEFT(true, false, -1),
    NONE(false, false, 0),
    RIGHT(false, true, 1);

    private final boolean left;
    private final boolean right;
    private final int value;

    Direction(boolean left, boolean right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
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

    public int move(int index) {
        return index + value;
    }

}
