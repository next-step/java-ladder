package nextstep.ladder.domain;

import java.util.Objects;

public class Column {
  private final int column;

  public Column(int column, int playerCount) {
    validate(column, playerCount);
    this.column = column;
  }

  private void validate(int column, int playerCount) {
    if (column < 0 || column >= playerCount) {
      throw new IllegalArgumentException(String.format("열은 0 초과 플레이어 수 미만의 값이어야 합니다. 입력받은 값 -> 열: %s, 플레이어 수: %s", column, playerCount));
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
    Column column1 = (Column) o;
    return column == column1.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(column);
  }
}
