package nextstep.ladder.domain;

// 참여할 사람
public class Person {
  private static final int MAX_LEN_OF_NAME = 5;
  private final String name;

  public Person(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() > MAX_LEN_OF_NAME) {
      throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있습니다.");
    }
  }

  public String getName() {
    return name;
  }
}
