package laddergame.model;

import java.util.Objects;

public class PlayerName {

  private final Name name;

  private PlayerName(Name name) {
    this.name = name;
  }

  public static PlayerName createBy(String name) {
    return new PlayerName(new Name(name));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerName that = (PlayerName) o;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
