package nextstep.ladder.domain.ladder;

public class Ladder implements Comparable<Ladder> {

    private final Position row;
    private final Position column;

    public Ladder(int row, int column) {
        this(new Position(row), new Position(column));
    }

    public Ladder(Position row, Position column) {
        this.row = row;
        this.column = column;
    }

    public Position getRow() {
        return row;
    }

    public Position getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public int compareTo(Ladder other) {
        int rowCompare = this.row.compareTo(other.row);
        if (rowCompare != 0) {
            return rowCompare;
        }
        return this.column.compareTo(other.column);
    }
}
