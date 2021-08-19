package ladderGame.step3.model;

import java.util.Objects;

public class PlayerName {

  public static final String MSG_ERROR_FAIL_NAME_LENGTH = "사용자명은 최대 5글자까지 가능합니다.";

  public static final String MSG_ERROR_FAIL_NAME_EMPTY = "사용자이름을 입력 해주세요.";

  private static final int LIMIT_NAME_LENGTH = 5;

  private final String name;

  public PlayerName(final String name) {
    validation(name);
    this.name = name;
  }

  public String writeName(){
    return String.valueOf(name);
  }

  private void validation(final String name) {
    checkNameEmpty(name);
    checkNameLength(name);
  }

  private void checkNameEmpty(final String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_FAIL_NAME_EMPTY);
    }
  }

  private void checkNameLength(final String name) {
    if (name.length() > LIMIT_NAME_LENGTH) {
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
    final PlayerName name1 = (PlayerName) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}