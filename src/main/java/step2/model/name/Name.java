package step2.model.name;

import step2.error.InvalidNameException;

import java.util.Optional;

public class Name {
  private static final String INVALID_NAME_EXCEPTION_MESSAGE = "잘못된 이름입니다.";
  private static final int LENGTH_LIMIT = 5;

  private final String name;

  public Name(String name) {
    checkName(name);
    this.name = name;
  }

  private void checkName(String name) {
    Optional.ofNullable(name).orElseThrow(() -> new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE));
    if (name.length() > LENGTH_LIMIT) {
      throw new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE);
    }
  }
}
