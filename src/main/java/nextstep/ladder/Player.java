package nextstep.ladder;

import java.util.Objects;

public class Player {

  private String name;

  public Player(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
