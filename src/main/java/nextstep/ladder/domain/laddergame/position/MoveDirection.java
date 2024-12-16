package nextstep.ladder.domain.laddergame.position;

import java.util.Arrays;

public enum MoveDirection {
    LEFT(-1) {
        public boolean canMove(boolean left, boolean right) {
            return left && !right;
        }
    },
    RIGHT(1) {
        public boolean canMove(boolean left, boolean right) {
            return !left && right;
        }
    },
    PASS(0) {
        public boolean canMove(boolean left, boolean right) {
            return !left && !right;
        }
    };

    private int direction;

    MoveDirection(int direction) {
        this.direction = direction;
    }

    public static int move(boolean left, boolean right) {
        return Arrays.stream(values())
                     .filter(direction -> direction.canMove(left, right))
                     .findFirst()
                     .map(MoveDirection::getDirection)
                     .orElseThrow(() -> new IllegalArgumentException("포인트를 확인해주세요."));
    }

    public int getDirection() {
        return direction;
    }

    public abstract boolean canMove(boolean left, boolean right);
}
