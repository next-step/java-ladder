package ladder.domain.participant;

import ladder.exception.InvalidPositionNumberException;

import java.util.Objects;

public class Position {

    private final int row;
    private final int column;

    private Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public static Position from(int startPosition) {
        if(startPosition < 0) {
            throw new InvalidPositionNumberException(startPosition);
        }
        return new Position(startPosition, 0);
    }

    public Position move(int row) {
        if(Math.abs(row) != 1 && row != 0) {
            throw new InvalidPositionNumberException(row);
        }
        return new Position(this.row + row, this.column + 1);
    }

    public int getRow() {
        return this.row;
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
