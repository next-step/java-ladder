package nextstep.ladder.codeleesh.domain;

import java.util.Arrays;

public enum Direction {
    RIGHT(false, true),
    DOWN(false, false),
    LEFT(true, false);

    private final boolean left;
    private final boolean right;

    Direction(final boolean left, final boolean right) {

        this.left = left;
        this.right = right;
    }

    public static Direction first(final boolean right) {

        return Direction.of(false, right);
    }

    public static Direction of(final boolean left, final boolean right) {

        return Arrays.stream(Direction.values())
                .filter(direction -> direction.left == left && direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 사다리는 그릴 수 없습니다."));
    }

    Direction direct(boolean right) {

        if (this.right && right) {
            return Direction.of(this.right, false);
        }
        return Direction.of(this.right, right);
    }

    public Direction next(final boolean right) {

        return direct(right);
    }

    public boolean duplicate() {

        return this.left && this.right;
    }

    public boolean isLeft() {

        return left;
    }

    public boolean isRight() {

        return right;
    }
}
