package ladder.domain;

import java.util.Arrays;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false),
    ;

    public static final String MAXIMUM_DIRECTION_IS_ONE = "maximum direction is one";
    
    private final boolean left;
    private final boolean right;

    Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
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

}
