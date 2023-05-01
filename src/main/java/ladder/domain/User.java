package ladder.domain;

public class User {

  private static final String ILLEGAL_NAME_MESSAGE = "이름은 최대 5글자까지 부여할 수 있습니다. 현재 이름 : ";
  private static final int NAME_LENGTH = 5;
  private final String name;

  public User(String name) {
    validateUserName(name);

    this.name = name;
  }

  private static void validateUserName(String name) {
    if (name.length() > NAME_LENGTH) {
      throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE + name);
    }
  }

  public String name() {
    return this.name;
  }
}
