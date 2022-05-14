package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

  private static final int MIN_LENGTH = 1;
  private static final int MAX_LENGTH = 5;
  private static final String VALIDATE_MESSAGE = "이름은 %d자 이상, %d자 이하여야 합니다.";

  private final String value;

  public Name(String value) {
    validate(value);
    this.value = value;
  }

  private static void validate(String value) {
    if (value == null) {
      throw new IllegalArgumentException(
          String.format(VALIDATE_MESSAGE, MIN_LENGTH, MAX_LENGTH)
      );
    }
    int length = value.length();
    if (length < MIN_LENGTH || length > MAX_LENGTH) {
      throw new IllegalArgumentException(
          String.format(VALIDATE_MESSAGE, MIN_LENGTH, MAX_LENGTH)
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
