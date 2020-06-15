package laddergame.domain.player;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Height;

public class Position {
    private static final int START_HEIGHT = 1;
    private static final int MIN_COLUMN = 1;
    private final Height height;
    private final Column column;

    public Position(int column) {
        this.height = new Height(START_HEIGHT);
        this.column = new Column(column);
    }

    public int getHeight() {
        return this.height.getHeight();
    }

    public int getColumn() {
        return this.column.getColumn();
    }
}
