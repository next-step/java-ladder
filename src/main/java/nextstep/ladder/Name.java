package nextstep.ladder;

import java.util.Objects;

public final class Name {

  public static final int MAX_LENGTH = 5;

  private final String name;

  public Name(final String name) {
    this.name = name;
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
