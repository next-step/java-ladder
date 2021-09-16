package ladder.model;

import java.util.Objects;

public class LimitedString {

  private static final int MIN_LENGTH = 1;
  private static final int MAX_LENGTH = 5;

  private final String value;

  public LimitedString(String value) {
    validateLength(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private void validateLength(String str) {
    if (str.length() < MIN_LENGTH || str.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(
          "제한된 문자길이는 " + MIN_LENGTH + " ~ " + MAX_LENGTH + " 글자 입니다"
      );
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
    LimitedString limitedString = (LimitedString) o;
    return Objects.equals(value, limitedString.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
