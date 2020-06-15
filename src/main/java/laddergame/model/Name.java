package laddergame.model;

import java.util.Objects;

public class Name {

  private final static int MAX_LENGTH = 5;
  private final static String WHITESPACE = " ";

  private final String value;

  public Name(String value) {
    value = value.trim();

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
    StringBuilder result = new StringBuilder(value);

    for (int i = value.length(); i <= MAX_LENGTH; i++) {
      result.insert(0, WHITESPACE);
    }

    return result.toString();
  }
}
