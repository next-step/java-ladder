package ladder.domain;

public enum DirectionType {
    LEFT_DIRECTION,
    RIGHT_DIRECTION,
    NONE;

    public static DirectionType of(boolean left, boolean right) {
        if (left) {
            return LEFT_DIRECTION;
        }

        if (right) {
            return RIGHT_DIRECTION;
        }

        return NONE;
    }
}
