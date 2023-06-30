package nextstep.ladder.domain;

import java.util.Objects;

public class LadderPoint {
  private final Row row;
  private final Column column;

  public LadderPoint(int row, int ladderLen, int column, int playerCount) {
    this(new Row(row, ladderLen), new Column(column, playerCount));
  }

  public LadderPoint(Row row, Column column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderPoint that = (LadderPoint) o;
    return Objects.equals(row, that.row) && Objects.equals(column, that.column);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }
}
