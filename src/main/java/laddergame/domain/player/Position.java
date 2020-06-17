package laddergame.domain.player;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Height;

import java.util.Objects;

public class Position {
    private static final int START_HEIGHT = 1;
    private static final int MIN_COLUMN = 1;
    private final Height height;
    private final Column column;

    public Position(int column) {
        this.height = new Height(START_HEIGHT);
        this.column = new Column(column);
    }

    public Position(int column, int height) {
        this.height = new Height(height);
        this.column = new Column(column);
    }

    public int getHeight() {
        return this.height.getHeight();
    }

    public int getColumn() {
        return this.column.getColumn();
    }

    public Column column() {
        return this.column;
    }

    public Height height() {
        return this.height;
    }

    public Position moveLeft() {
        return new Position(column.getColumn() - 1, height.getHeight());
    }

    public Position moveRight() {
        return new Position(column.getColumn() + 1, height.getHeight());
    }

    public Position moveDown() {
        return new Position(column.getColumn(), height.getHeight() + 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getHeight(), position.getHeight()) &&
                Objects.equals(getColumn(), position.getColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getColumn());
    }
}
