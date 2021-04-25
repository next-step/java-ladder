package ladder.domain;

import java.util.Objects;

public class Player {
  public static final int MAX_VALUE_LENGTH = 5;

  private final Name value;

  private Player(Name value) {
    this.value = value;
  }

  public static Player create(String name) {
    return new Player(Name.ofBlankSafeWithCheckLength(name, MAX_VALUE_LENGTH));
  }

  public String name() {
    return value.getValue();
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
