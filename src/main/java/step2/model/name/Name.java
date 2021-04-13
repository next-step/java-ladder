package step2.model.name;

import step2.error.InvalidNameException;

import java.util.Objects;
import java.util.Optional;

public class Name {
  private static final String INVALID_NAME_EXCEPTION_MESSAGE = "잘못된 이름입니다.";
  private static final int LENGTH_LIMIT = 5;

  private final String name;

  public Name(String name) {
    checkName(name);
    this.name = name.trim();
  }

  private void checkName(String name) {
    Optional.ofNullable(name).orElseThrow(() -> new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE));
    String nameWithTrim = name.trim();
    if (nameWithTrim.length() > LENGTH_LIMIT) {
      throw new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
