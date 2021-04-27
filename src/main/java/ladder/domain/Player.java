package ladder.domain;

import ladder.exception.PlayerNameBlankException;
import ladder.exception.PlayerNameOverLimitLengthException;

import java.util.Objects;

public class Player {
  private final String value;

  private Player(String value) {
    this.value = value;
  }

  public static Player create(String name) {
    PlayerNameBlankException.verify(name);
    PlayerNameOverLimitLengthException.verify(name);
    return new Player(name);
  }

  public String name() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return Objects.equals(value, player.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Player name=" + value;
  }
}
