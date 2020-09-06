package ladder.domain;

import lombok.Builder;

import java.util.Objects;

public class Position {
    private int row;
    private int column;

    @Builder
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Position left() {
        return new Position(row, column - 1);
    }

    public Position right() {
        return new Position(row, column + 1);
    }

    public Position down() {
        return new Position(row + 1, column);
    }

    public boolean checkLine(Ladder ladder) {
        return ladder.checkLine(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
