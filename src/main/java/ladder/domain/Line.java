package ladder.domain;

import java.util.Objects;
import ladder.utils.LineStrategy;

public class Line {

  private final Column column;
  private final Row row;

  public Line(int columnPosition, int rowPosition) {
    this.column = Column.of(columnPosition);
    this.row = Row.of(rowPosition);
  }

  public Line(Column column, Row row) {
    this.column = column;
    this.row = row;
  }

  public static Line any(LineStrategy lineStrategy) {
    return new Line(lineStrategy.anyColumn(), lineStrategy.anyRow());
  }

  public boolean isSame(int columnPosition, int rowPosition) {
    return this.isSame(new Line(columnPosition, rowPosition));
  }

  public boolean isSame(Line other) {
    return column.isSame(other.column) && row.isSame(other.row);
  }

  public boolean isSameRow(Line otherLine) {
    return this.row.isSame(otherLine.row);
  }

  public boolean isAdjacentColumn(Line otherLine) {
    return otherLine.column.isAdjacent(this.column);
  }

  public Row getRow() {
    return this.row;
  }

  public Column getColumn() {
    return this.column;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Line otherLine = (Line) o;
    return this.hashCode() == otherLine.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(column, row);
  }
}
