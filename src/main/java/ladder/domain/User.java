package ladder.domain;

import java.util.Objects;
import ladder.exception.OutOfUserNameLengthException;

public class User {

  private final String name;

  public User(String name) {
    validateUsernameLength(name);
    this.name = name;
  }

  private void validateUsernameLength(String name) {
    if (name.length() > 5) {
      throw new OutOfUserNameLengthException();
    }
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User other = (User) o;
    return this.name.equals(other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "User{"
        + "name='"
        + name
        + '\''
        + '}';
  }
}
