package domain;

import java.util.Arrays;

public enum DirectionGroup {
    LEFT(true, false, new Direction(Boolean.TRUE, Boolean.FALSE)),
    RIGHT(false, true, new Direction(Boolean.FALSE, Boolean.TRUE)),
    CENTER(false, false, new Direction(Boolean.FALSE, Boolean.FALSE));

    private boolean right;
    private boolean left;
    private Direction direction;

    DirectionGroup(boolean right, boolean left, Direction direction) {
        this.right = right;
        this.left = left;
        this.direction = direction;
    }

    public static DirectionGroup valueOf(boolean right, boolean left) {

        return Arrays.stream(DirectionGroup.values()).
                filter((direction) -> direction.right == right && direction.left == left)
                .findFirst()
                .orElse(DirectionGroup.CENTER);
    }

    public Direction getDirection() {
        return direction;
    }

}
