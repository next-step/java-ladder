package ladder.domain.player;

import java.util.Objects;

public class Player {
  private final String name;

  private static final int MAX_NAME_LENGTH = 5;

  public Player(String name) {
    throwIfHasInvalidName(name);
    this.name = name;
  }

  private void throwIfHasInvalidName(String name) {
    if(name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("사다리게임 플레이어 최대 허용 이름 길이를 초과하였습니다.");
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player that = (Player) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return String.format("%5s", name);
  }
}
