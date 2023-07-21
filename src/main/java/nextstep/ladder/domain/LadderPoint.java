package nextstep.ladder.domain;

import java.util.Objects;

public class LadderPoint {
  private final int row;
  private final int column;
  private final LadderBarStatus ladderBarStatus;

  public LadderPoint(int row, int column, LadderBarStatus ladderBarStatus) {
    this.row = row;
    this.column = column;
    this.ladderBarStatus = ladderBarStatus;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public LadderBarStatus getLadderBarStatus() {
    return ladderBarStatus;
  }

  @Override
  public String toString() {
    return "LadderPoint{" +
        "row=" + row +
        ", column=" + column +
        ", ladderBarStatus=" + ladderBarStatus +
        '}';
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
    return getRow() == that.getRow() && getColumn() == that.getColumn()
        && getLadderBarStatus() == that.getLadderBarStatus();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRow(), getColumn(), getLadderBarStatus());
  }
}
