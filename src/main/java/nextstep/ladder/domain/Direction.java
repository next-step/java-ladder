package nextstep.ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    STRAIGHT(0);

    private static final String EXCEPTION_MESSAGE_DIRECTION = "올바른 방향이 아닙니다.";

    private final int movePosition;

    Direction(int movePosition) {
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
