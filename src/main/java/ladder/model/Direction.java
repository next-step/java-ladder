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

    Position moveRight(Position position) {
        return new Position(position.getValue() + 1);
    }

    Position moveLeft(Position position) {
        return new Position(position.getValue() - 1);
    }

    public static Direction of(boolean left, boolean right) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.left == left && Direction.right == right)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연속된 Direction은 만들수 없습니다"));
    }

    public Position move(final Position position) {
        if (this == Direction.RIGHT) return moveRight(position);
        if (this == Direction.LEFT)  return moveLeft(position);
        return new Position(position.getValue());
    }
}
