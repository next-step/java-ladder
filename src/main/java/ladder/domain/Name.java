package ladder.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
  private final String name;
  private final Pattern pattern = Pattern.compile(INVALID_PATTERN_REGEX);
  private final static String INVALID_PATTERN_REGEX = "^[가-힣a-zA-Z]*$";
  private final static String INVALID_NAME = "영어와 한글만 입력하세요.";
  private final static String INVALID_NAME_LENGTH = "이름은 5글자이하여야 합니다.";

  public Name(String name) {
    this.name = name;
    validateName();
    validateNameLength();
  }

  private void validateNameLength() {
    if (name.length() > 5) {
      throw new IllegalArgumentException(INVALID_NAME_LENGTH);
    }
  }

  private void validateName() {
    if(!pattern.matcher(name).matches()) {
      throw new IllegalArgumentException(INVALID_NAME);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name) && Objects
        .equals(pattern, name1.pattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, pattern);
  }
}
