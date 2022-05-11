package ladder.domain;

import java.security.InvalidParameterException;

public class UserName {

  private static final String EMPTY_NAME_MESSAGE = "사용자 이름은 공백이 허용되지 않습니다.";
  private static final String INVALID_LENGTH_MESSAGE = "사용자 이름의 길이는 %d 이하여야 합니다.";
  public static final int LENGTH_LIMIT = 5;
  private final String name;

  private UserName(String name) {
    assertName(name);
    this.name = name;
  }

  public static UserName of(String name) {
    return new UserName(name);
  }

  private void assertName(String name) {
    if (name == null || name.isBlank()) {
      throw new InvalidParameterException(EMPTY_NAME_MESSAGE);
    }

    if (name.length() > LENGTH_LIMIT) {
      throw new InvalidParameterException(String.format(INVALID_LENGTH_MESSAGE, LENGTH_LIMIT));
    }
  }

  public String getName() {
    return name;
  }
}