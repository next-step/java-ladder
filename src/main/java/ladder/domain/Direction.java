package ladder.domain;

import java.util.Arrays;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false);

    private static final String EXCEPTION_BOTH_TRUE = "가로 라인은 한 좌표에 하나만 가질 수 있습니다.";
    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(EXCEPTION_BOTH_TRUE);
        }
        return Arrays.stream(values())
                .filter(direction -> direction.left == left && direction.right == right)
                .findFirst()
                .orElse(NONE);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
