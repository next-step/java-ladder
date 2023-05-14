package nextstep.laddergame.vo;

import nextstep.laddergame.domain.ladder.Lines;

public enum DirectionType {
    DOWN(() -> 0),
    LEFT(() -> -1),
    RIGHT(() -> 1);

    private final MoveStrategy moveStrategy;

    DirectionType(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public static DirectionType checkDirection(int row, int col, Lines lines) {
        if (lines.isLeftDirection(row, col)) {
            return LEFT;
        }
        if (lines.isRightDirection(row, col)) {
            return RIGHT;
        }
        return DOWN;
    }

    public int moveRow() {
        return moveStrategy.move();
    }
}
