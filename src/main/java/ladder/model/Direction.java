package ladder.model;

import java.util.EnumSet;

public enum Direction {

    RIGHT(false, true),
    LEFT(true, false),
    PASS(false, false);

    private final boolean current;
    private final boolean right;

    Direction(boolean current, boolean right) {
        this.current = current;
        this.right = right;
    }

    public static Direction of(boolean current, boolean right) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.current == current && Direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 Direction은 만들수 없습니다"));
    }
}
