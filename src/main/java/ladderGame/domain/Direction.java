package ladderGame.domain;

import java.util.EnumSet;

public enum Direction {
    RIGHT(false, true),
    LEFT(true, false),
    STRAIGHT(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction decide(boolean left, boolean right) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.left == left && Direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 계단은 만들어 질 수 없어"));
    }
}
