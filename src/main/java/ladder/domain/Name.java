package ladder.domain;

import ladder.util.StringUtil;

import java.util.Objects;

public class Name {
  private static final String EXCEPTION_MESSAGE_OF_BLANK_STRING = "이름은 null 또는 빈 문자열을 입력할 수 없습니다.";
  private static final String EXCEPTION_MESSAGE_OF_INVALID_LENGTH_FORMAT = "이름(%s)은 %d 길이를 초과했습니다.";

  private final String value;

  private Name(String value) {
    this.value = value;
  }

  public static Name ofBlankSafeWithCheckLength(String name, int maxLength) {
    checkBlankName(name);
    checkNameLength(name, maxLength);
    return new Name(name);
  }

  private static void checkBlankName(String name) {
    if (StringUtil.isBlank(name)) {
      throw new IllegalArgumentException(EXCEPTION_MESSAGE_OF_BLANK_STRING);
    }
  }

  private static void checkNameLength(String name, int maxLength) {
    if (name.length() > maxLength) {
      throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_OF_INVALID_LENGTH_FORMAT,
              name, maxLength));
    }
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name = (Name) o;
    return Objects.equals(value, name.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Name=" + value;
  }
}
