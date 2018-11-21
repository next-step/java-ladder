package domain.ladder;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum DirectionKind {
    LEFT(true, false , new Direction(TRUE, FALSE)),
    RIGHT(false, true , new Direction(FALSE, TRUE)),
    STOP(false, false , new Direction(FALSE, FALSE));

    private boolean left;
    private boolean right;
    private Direction direction;

    DirectionKind(boolean left, boolean right, Direction direction) {
        this.left = left;
        this.right = right;
        this.direction = direction;
    }

    public static DirectionKind findDirection(boolean left, boolean right){
        return Arrays.stream(values())
                    .filter(v -> v.left == left && v.right == right)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }

    public Direction getDirection() {
        return direction;
    }
}
