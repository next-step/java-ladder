package laddergame.model;

import java.util.Objects;

public class Player {

  private final Name name;

  public Player(Name name) {
    this.name = name;
  }

  public static Player createByNameStr(String nameStr) {
    return new Player(new Name(nameStr));
  }

  public Name getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return name.equals(player.name);
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
