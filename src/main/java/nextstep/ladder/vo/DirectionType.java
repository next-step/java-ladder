package nextstep.ladder.vo;

import nextstep.ladder.domain.line.Lines;

public enum DirectionType {
    DOWN, LEFT, RIGHT;

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
        if (this.equals(LEFT)) {
            return -1;
        }
        if (this.equals(RIGHT)) {
            return 1;
        }
        return 0;
    }
}
