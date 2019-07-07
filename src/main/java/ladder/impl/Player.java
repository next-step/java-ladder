package ladder.impl;

import java.util.Objects;

public class Player {

  private static final int LIMIT_NAME_LENGTH = 5;
  private static final int PRINT_NAME_LENGTH = 6;
  private static final String BLANK_SYMBOL = " ";
  private String name;

  public Player(String name) {
    if (isBlank(name)) {
      throw new IllegalArgumentException("이름은 공백이면 안됨니다.");
    }
    if (isValidLength(name)) {
      throw new IllegalArgumentException("이름은 5자 이상 일 수 없습니다.");
    }
    this.name = name;
  }

  private boolean isValidLength(String name) {
    return name.length() > LIMIT_NAME_LENGTH;
  }

  private boolean isBlank(String name) {
    return name == null || "".equals(name.trim());
  }

  public String getName() {
    return name.trim();
  }

  @Override
  public String toString() {
    int diff = PRINT_NAME_LENGTH - name.length();
    for (int i = 0; i < diff; i++) {
      name += BLANK_SYMBOL;
    }
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
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
