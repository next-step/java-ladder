package laddergame.domain.player;

public class Position {
    private static final int START_HEIGHT = 1;
    private static final int MIN_COLUMN = 1;
    private final int height;
    private final int column;

    public Position(int column) {
        validateColumn(column);
        this.height = START_HEIGHT;
        this.column = column;
    }

    public int getHeight() {
        return this.height;
    }

    public int getColumn() {
        return this.column;
    }

    private void validateColumn(int column) {
        if (column < MIN_COLUMN) {
            throw new IllegalArgumentException("Column 번호는 1 이상이어야 합니다. - " + column);
        }
    }
}
