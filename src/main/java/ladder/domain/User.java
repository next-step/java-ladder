package ladder.domain;

import java.util.Objects;

public class User {

  private final Name name;

  public User(String name) {
    this(new Name(name));
  }

  public User(Name name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public String name() {
    return name.name();
  }

}
