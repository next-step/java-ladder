package nextstep.ladder.domain;

import java.util.Objects;

public class Row {
  private final int row;

  public Row(int row, int ladderLen) {
    validate(row, ladderLen);
    this.row = row;
  }

  private void validate(int row, int ladderLen) {
    if (row < 0 || row > ladderLen) {
      throw new IllegalArgumentException(String.format("행은 0 ~ 사다리 길이를 넘을 수 없습니다. 입력받은 값 -> 행: %s, 사다리 길이: %s", row, ladderLen));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Row row1 = (Row) o;
    return row == row1.row;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row);
  }
}
