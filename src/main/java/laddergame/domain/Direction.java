package laddergame.domain;

import java.util.function.UnaryOperator;

public enum Direction {

    RIGHT(position -> position + 1),
    LEFT(position -> position - 1),
    NONE(position -> position)
    ;

    private final UnaryOperator<Integer> nextLinePositionCalculation;

    Direction(UnaryOperator<Integer> nextLinePositionCalculation) {
        this.nextLinePositionCalculation = nextLinePositionCalculation;
    }

    public static Direction of(boolean isRight, boolean isLeft) {
        if (isRight && isLeft) {
            throw new IllegalArgumentException("오른쪽이면서 동시에 왼쪽인 방향은 존재하지 않습니다.");
        }
        if (isRight) {
            return RIGHT;
        }
        if (isLeft) {
            return LEFT;
        }
        return NONE;
    }

    public int getNextLinePosition(int position) {
        return nextLinePositionCalculation.apply(position);
    }

}
