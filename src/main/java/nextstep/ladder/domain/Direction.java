package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;
import java.util.Random;

public enum Direction {

    LEFT(true, false),
    NONE(false, false),
    RIGHT(false, true);

    private static Random random = new Random();
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

    public static Direction generateFirst() {
        return Direction.of(false, random.nextBoolean());
    }

    public static Direction generateLast(Direction before) {
        return Direction.of(before.right, false);
    }

    public static Direction next(Direction before) {
        if (before.right) {
            return Direction.of(true, false);
        }
        return Direction.of(false, random.nextBoolean());
    }

}
