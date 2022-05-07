package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

  private static int MIN_LENGTH = 1;
  private static int MAX_LENGTH = 5;

  private final String value;

  public Name(String value) {
    validateLength(value);
    this.value = value;
  }

  private static void validateLength(String value) {
    if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          String.format("이름은 %d자 이상, %d자 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH)
      );
    }
  }

  String getValue() {
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
    Name name = (Name) o;
    return Objects.equals(value, name.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
