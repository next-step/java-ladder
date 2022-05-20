package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

  private final String name;

  public Player(String name) {
    if (name == null || name.length() > 5) {
      throw new IllegalArgumentException("플레이어 이름은 최대 5글자만 가능합니다.");
    }
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
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
