package ladder.domain;

import java.util.Objects;

public class Player {
  private static final String EXCEPTION_MESSAGE_FORMAT = "이름(%s)은 %d 길이를 초과했습니다.";
  private static final int MAX_VALUE_LENGTH = 5;

  private final String value;

  private Player(String value) {
    this.value = value;
  }

  public static Player create(String name) {
    checkNameLength(name);
    return new Player(name);
  }

  public static boolean isValidName(String name) {
    return name != null
            && !name.isEmpty()
            && name.length() <= MAX_VALUE_LENGTH;
  }

  private static void checkNameLength(String name) {
    if (!isValidName(name)) {
      throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FORMAT
              , name, MAX_VALUE_LENGTH));
    }
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
