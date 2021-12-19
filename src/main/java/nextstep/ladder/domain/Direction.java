package nextstep.ladder.domain;

public enum Direction {
    LEFT(true, false, -1),
    RIGHT(false, true, 1),
    STRAIGHT(false, false, 0);

    private static final String EXCEPTION_MESSAGE_DIRECTION = "올바른 방향이 아닙니다.";

    private final boolean left;
    private final boolean right;
    private final int movePosition;

    Direction(boolean left, boolean right, int movePosition) {
        this.left = left;
        this.right = right;
        this.movePosition = movePosition;
    }

    public static Direction valueOf(boolean left, boolean right) {
        if (left && !right) {
            return Direction.LEFT;
        }
        if (!left && right) {
            return Direction.RIGHT;
        }
        if (!left && !right) {
            return Direction.STRAIGHT;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_DIRECTION);
    }

    public int getMovePosition() {
        return movePosition;
    }
}
