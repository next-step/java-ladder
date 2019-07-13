package ladder.domain;

import java.util.Objects;

public class Player {

  private static final int MAX_PLAYER_NAME = 5;
  static final String NAME_PRINT_FORMAT = "%-5s";

  private String name;

  private Player(String name) {
    validateNameSize(name);

    this.name = name;
  }

  private void validateNameSize(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("플레이어 이름이 잘못되었습니다 : " + name);
    }
    if (name.length() > MAX_PLAYER_NAME) {
      throw new IllegalArgumentException("플레이어 이름이 너무 깁니다. 최대 글자수 : " + MAX_PLAYER_NAME);
    }
  }

  public static Player of(String name) {
    return new Player(name);
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
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return String.format(NAME_PRINT_FORMAT, name);
  }

  boolean isPlayerName(String name) {
    return this.name.equalsIgnoreCase(name);
  }
}
