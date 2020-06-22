package laddergame.domain.vo;

import java.util.Objects;

public class Position {
    private static final int START_HEIGHT = 1;
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

    public Column getColumn() {
        return this.column;
    }

    public Height getHeight() {
        return this.height;
    }

    public Position moveLeft() {
        return new Position(column.toInt() - 1, height.toInt());
    }

    public Position moveRight() {
        return new Position(column.toInt() + 1, height.toInt());
    }

    public Position moveDown() {
        return new Position(column.toInt(), height.toInt() + 1);
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
