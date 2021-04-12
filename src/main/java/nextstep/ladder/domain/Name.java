package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.OverNameLengthLimitException;

public final class Name {

  public static final int MAX_LENGTH = 5;

  private final String name;

  public Name(final String name) {
    validateNameLength(name);
    this.name = name;
  }

  private void validateNameLength(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new OverNameLengthLimitException();
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
    if (!(o instanceof Name)) {
      return false;
    }
    Name otherName = (Name) o;
    return Objects.equals(name, otherName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
