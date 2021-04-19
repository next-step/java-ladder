package ladder.model.member;

import ladder.error.InvalidNameException;

import java.util.Objects;
import java.util.Optional;

public class Player {
  private static final String INVALID_NAME_EXCEPTION_MESSAGE = "잘못된 이름입니다.";
  private static final int LENGTH_LIMIT = 5;

  private final String name;

  public Player(String name) {
    checkName(name);
    this.name = name.trim();
  }

  public String name() {
    return name;
  }

  public int size() {
    return name.length();
  }

  private void checkName(String name) {
    Optional.ofNullable(name).orElseThrow(() -> new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE));
    String nameWithTrim = name.trim();
    if (nameWithTrim.length() > LENGTH_LIMIT) {
      throw new InvalidNameException(INVALID_NAME_EXCEPTION_MESSAGE);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player1 = (Player) o;
    return Objects.equals(name, player1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
