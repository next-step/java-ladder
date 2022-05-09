package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

  private final Name name;

  public Player(Name name) {
    this.name = name;
  }

  public static Player of(String name) {
    return new Player(new Name(name));
  }

  String getName() {
    return name.getValue();
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
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
