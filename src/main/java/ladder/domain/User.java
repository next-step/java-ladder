package ladder.domain;

import java.util.Objects;

public class User {

  public static final Integer MAX_USER_NAME_LENGTH = 5;
  public static final String INVALID_USER_NAME_INPUT = "올바르지 않은 유저 명이 들어왔습니다. 유저 명 혹은 길이를 확인해주세요. input: %s, maxLength: %s";

  private String name;

  public User(String name) {
    validate(name);
    this.name = name;
  }

  public boolean isSame(String given) {
    return this.name.equals(given);
  }

  private void validate(String name) {
    if (name.length() > MAX_USER_NAME_LENGTH) {
      throw new IllegalArgumentException(String.format(INVALID_USER_NAME_INPUT, name, MAX_USER_NAME_LENGTH));
    }
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
    return Objects.hash(name);
  }
}
