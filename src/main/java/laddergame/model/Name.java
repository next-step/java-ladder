package laddergame.model;

import java.util.Objects;

public class Name {

  private static int MAX_LENGTH = 5;
  String value;

  public Name(String value) {
    if (MAX_LENGTH < value.length()) {
      throw new IllegalArgumentException("이름이 5글자 초과 value : " + value);
    }

    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return value.equals(name.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
