package laddergame.domain.ladder;

import java.util.stream.Stream;

public enum BridgeType {
    LEFT(-1, true),
    RIGHT(1, true),
    NONE(0, false);

    private final int moveValue;
    private final boolean isConnected;

    BridgeType(int moveValue, boolean isConnected) {
        this.moveValue = moveValue;
        this.isConnected = isConnected;
    }

    public static BridgeType findByMoveValue(int moveValue) {
        return Stream.of(values())
                .filter(bridgeType -> bridgeType.moveValue == moveValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값을 입력하였습니다. - " + moveValue));
    }

    public int getMoveValue() {
        return moveValue;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isRightConnected() {
        return this == BridgeType.RIGHT;
    }
}
