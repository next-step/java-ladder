package ladder.domain;

import java.util.Objects;

public class User {

  private final Name name;
  private final Position position;

  public User(String name, int position) {
    this(new Name(name), new Position(position));
  }

  public User(Name name, Position position) {
    this.name = name;
    this.position = position;
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
