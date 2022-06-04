package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

  public static final int MAX_NAME_LENGTH = 5;
  private final String name;

  public Player(String name) {
    validateEmpty(name);
    validateLength(name.trim());
    this.name = name.trim();
  }

  private void validateEmpty(String name) {
    if (isBlank(name)) {
      throw new IllegalArgumentException("플레이어 이름은 비어 있을 수 없습니다.");
    }
  }

  private void validateLength(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("플레이어 이름은 최대 5글자만 가능합니다.");
    }
  }

  private static boolean isBlank(String name) {
    return name == null || name.isBlank();
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
