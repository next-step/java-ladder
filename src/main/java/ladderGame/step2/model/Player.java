package ladderGame.step2.model;

import java.util.Objects;

public class Player {

  private final Name name;

  public Player(final String name) {
    this.name = new Name(name);
  }

  public String findUserName() {
    return name.findNameByFormat();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
