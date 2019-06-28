package ladder;

import java.util.Objects;

public class Player {

  public static final int NAME_LIMIT_LENGTH = 5;

  String name;

  public Player(String name) {
    if(name.length() > NAME_LIMIT_LENGTH) {
      throw new IllegalArgumentException("이름은 다섯글자 이하여야 합니다.");
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
}
