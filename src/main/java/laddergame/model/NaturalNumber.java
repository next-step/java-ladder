package laddergame.model;

import java.util.Objects;

public class NaturalNumber {

  private final int value;

  public NaturalNumber(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("NaturalNumber는 0보다 작을 수 없습니다. value : " + value);
    }

    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public NaturalNumber plusOne() {
    return new NaturalNumber(value+1);
  }

  public NaturalNumber minusOne() {
    return new NaturalNumber(value-1);
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


