package nextstep.ladder.domain;

import java.util.Arrays;

public enum DirectionEnum{

    GOING_RIGHT(1){
        @Override
        protected boolean isAccept(boolean leftConnected, boolean rightConnected) {
            return rightConnected;
        }
    },
    GOING_LEFT(-1){
        @Override
        protected boolean isAccept(boolean leftConnected, boolean rightConnected) {
            return leftConnected;
        }
    },
    HOLD_POSITION(0){
        @Override
        protected boolean isAccept(boolean leftConnected, boolean rightConnected) {
            return !leftConnected && !rightConnected;
        }
    };

    private final int value;

    DirectionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    protected abstract boolean isAccept(boolean leftConnected, boolean rightConnected);

    public static DirectionEnum getDirection(boolean leftConnected, boolean rightConnected) {
        return Arrays.stream(values())
                .filter(direction -> direction.isAccept(leftConnected, rightConnected))
                .findFirst()
                .orElse(HOLD_POSITION);
    }
}
