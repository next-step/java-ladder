package laddergame.model;

import java.util.Objects;

public class Height {
  private final int value;

  public Height(int value) {
    if (value < 1) {
      throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다. value : " + value);
    }

    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Height that = (Height) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
