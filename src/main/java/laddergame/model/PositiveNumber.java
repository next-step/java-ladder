package laddergame.model;

import java.util.Objects;

public class PositiveNumber {
  private int value;

  public PositiveNumber(int value) {
    if (value < 1) {
      throw new IllegalArgumentException("PositiveNumber는 1보다 작을 수 없습니다. value : " + value);
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
    PositiveNumber that = (PositiveNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
