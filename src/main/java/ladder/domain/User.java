package ladder.domain;

import java.util.Objects;

public class User {

  private static final String ILLEGAL_NAME_MESSAGE = "이름은 최대 5글자까지 부여할 수 있습니다. 현재 이름 : ";
  private static final int NAME_LENGTH = 5;
  private final String name;

  public User(String name) {
    validateUserName(name);

    this.name = name;
  }

  private static void validateUserName(String name) {
    if (name.length() > NAME_LENGTH || name.isEmpty()) {
      throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE + name);
    }
  }

  public String name() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
