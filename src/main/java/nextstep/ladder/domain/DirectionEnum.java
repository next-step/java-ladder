package nextstep.ladder.domain;

public enum DirectionEnum {
    GOING_RIGHT(1),
    GOING_LEFT(-1),
    HOLD_POSITION(0);

    private final int value;

    DirectionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DirectionEnum getDirection(boolean leftConnected, boolean rightConnected) {
        if (leftConnected) {
            return GOING_LEFT;
        }
        if (rightConnected) {
            return GOING_RIGHT;
        }
        return HOLD_POSITION;
    }
}
