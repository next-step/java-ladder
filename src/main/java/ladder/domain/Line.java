package ladder.domain;

public class Line {
    private final Column column;
    private final Row row;

    public Line(int columnPosition, int rowPosition) {
        this.column = Column.of(columnPosition);
        this.row = Row.of(rowPosition);
    }

    public static Line any(LineStrategy lineStrategy) {
        return new Line(lineStrategy.anyColumn(), lineStrategy.anyRow());
    }

    public int columnPosition() {
        return column.getValue();
    }

    public int rowPosition() {
        return row.getValue();
    }

    public boolean isExist(int columnPosition, int rowPosition) {
        return (column.getValue() == columnPosition) && (row.getValue() == rowPosition);
    }

    public boolean isSameRow(Line otherLine) {
        return this.row.isSame(otherLine.row);
    }

    public boolean isAdjacentColumn(Line otherLine) {
        return Math.abs(this.columnPosition() - otherLine.columnPosition()) <= 1;
    }
}
