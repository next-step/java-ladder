package laddergame.model;

import java.util.Objects;

public class NaturalNumber {

  private int value;

  public NaturalNumber(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("NaturalNumber는 0보다 작을 수 없습니다. value : " + value);
    }

    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void plusOne() {
    new NaturalNumber(++value);
  }

  public void minusOne() {
    new NaturalNumber(--value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NaturalNumber that = (NaturalNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "NaturalNumber{" +
        "value=" + value +
        '}';
  }
}


