package ladder.domain.ladder;

import java.util.Arrays;

public enum Direction {
    LEFT(true, false, -1),
    RIGHT(false, true, 1),
    NONE(false, false, 0),
    ;

    public static final String MAXIMUM_DIRECTION_IS_ONE = "maximum direction is one";

    private final boolean left;
    private final boolean right;
    private final int movePositionVal;

    Direction(final boolean left, final boolean right, final int movePositionVal) {
        this.left = left;
        this.right = right;
        this.movePositionVal = movePositionVal;
    }

    public static Direction valueOf(final boolean left, final boolean right) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.hasLeft() == left)
                .filter(direction -> direction.hasRight() == right)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MAXIMUM_DIRECTION_IS_ONE));
    }

    public boolean hasLeft() {
        return left;
    }

    public boolean hasRight() {
        return right;
    }

    public int getMovePositionVal() {
        return movePositionVal;
    }

}
