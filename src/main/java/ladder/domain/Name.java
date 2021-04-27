package ladder.domain;

import ladder.exception.PlayerNameBlankException;
import ladder.exception.PlayerNameOverLimitLengthException;

import java.util.Objects;

public class Name {
  private final String value;

  private Name(String value) {
    this.value = value;
  }

  public static Name ofBlankSafeWithCheckLength(String name, int maxLength) {
    PlayerNameBlankException.verify(name);
    PlayerNameOverLimitLengthException.verify(name);
    return new Name(name);
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
