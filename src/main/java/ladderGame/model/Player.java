package ladderGame.model;

import java.util.Objects;

public class Player {

  private static final int LIMIT_NAME_LENGTH = 5;

  private static final String MSG_ERROR_FAIL_NAME_LENGTH = "사용자명은 최대 5글자까지 가능합니다.";

  private final String name;

  public Player(final String name) {
    this.name = name;
    validation(name);
  }

  private void validation(final String name) {
    if(name.length() > LIMIT_NAME_LENGTH){
      throw new IllegalArgumentException(MSG_ERROR_FAIL_NAME_LENGTH);
    }
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
