package laddergame.domain;

import java.util.List;

public enum LadderConnectedDirection {

    RIGHT(true, false),
    LEFT(false, true),
    NONE(false, false);

    private static final List<LadderConnectedDirection> VALUES = List.of(values());

    private final boolean rightConnected;
    private final boolean leftConnected;

    LadderConnectedDirection(boolean rightConnected, boolean leftConnected) {
        this.rightConnected = rightConnected;
        this.leftConnected = leftConnected;
    }

    public static LadderConnectedDirection of(boolean rightConnected, boolean leftConnected) {
        return VALUES.stream()
                .filter(direction -> direction.rightConnected == rightConnected
                        && direction.leftConnected == leftConnected)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 방향을 찾을 수 없습니다."));
    }

    public int getNextLinePosition(int position) {
        if (this == LadderConnectedDirection.RIGHT) {
            return position + 1;
        }

        if (this == LadderConnectedDirection.LEFT) {
            return position - 1;
        }

        return position;
    }

}
