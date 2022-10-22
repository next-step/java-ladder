package laddergame.domain;

import java.util.function.Function;

public enum LadderConnectedDirection {

    RIGHT(position -> position + 1),
    LEFT(position -> position - 1),
    NONE(position -> position);

    private final Function<Integer, Integer> nextLinePositionCalculation;

    LadderConnectedDirection(Function<Integer, Integer> nextLinePositionCalculation) {
        this.nextLinePositionCalculation = nextLinePositionCalculation;
    }

    public static LadderConnectedDirection of(boolean rightConnected, boolean leftConnected) {
        if (rightConnected && leftConnected) {
            throw new IllegalArgumentException("해당하는 방향을 찾을 수 없습니다.");
        }
        if (rightConnected) {
            return LadderConnectedDirection.RIGHT;
        }
        if (leftConnected) {
            return LadderConnectedDirection.LEFT;
        }
        return LadderConnectedDirection.NONE;
    }

    public int getNextLinePosition(int position) {
        return nextLinePositionCalculation.apply(position);
    }

}
