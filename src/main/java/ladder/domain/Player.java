package ladder.domain;

import ladder.exception.PlayerNameBlankException;
import ladder.exception.PlayerNameOverLimitLengthException;
import ladder.util.StringUtil;

import java.util.Objects;

public class Player {
  public static final int MAX_LENGTH = 5;

  private final String value;

  private Player(String value) {
    this.value = value;
  }

  public static Player create(String name) {
    checkBlankName(name);
    checkNameLength(name);
    return new Player(name);
  }

  private static void checkBlankName(String name) {
    if (StringUtil.isBlank(name)) {
      throw new PlayerNameBlankException();
    }
  }

  private static void checkNameLength(String name) {
    if (name.length() > MAX_LENGTH) {
      throw new PlayerNameOverLimitLengthException(MAX_LENGTH);
    }
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
