package ladder.domain;

public class Line {
    private final Column column;
    private final Row row;

    public Line(int columnPosition, int rowPosition) {
        this.column = new Column(columnPosition);
        this.row = new Row(rowPosition);
    }

    public static Line any(LineStrategy lineStrategy) {
        return new Line(lineStrategy.horizontalPosition(), lineStrategy.verticalPosition());
    }

    public int columnPosition() {
        return column.getValue();
    }

    public int rowPosition() {
        return row.getValue();
    }

    public boolean isExisit(int columnPosition, int rowPosition) {
        return (column.getValue() == columnPosition) && (row.getValue() == rowPosition);
    }

    public boolean isSameColum(Line otherLine) {
        return this.column.getValue() == otherLine.column.getValue();
    }

    public boolean isAdjacentRow(Line otherLine) {
        return Math.abs(this.columnPosition() - otherLine.columnPosition()) <= 1;
    }
}
