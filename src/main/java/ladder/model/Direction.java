package ladder.model;

import java.util.EnumSet;

public enum Direction {

    RIGHT(false, true),
    LEFT(true, false),
    PASS(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.left == left && Direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 Direction은 만들수 없습니다"));
    }

    public int move(int position) {
        if (this == Direction.RIGHT) {
            return position + 1;
        }

        if (this == Direction.LEFT) {
            return position - 1;
        }

        return position;
    }
}
