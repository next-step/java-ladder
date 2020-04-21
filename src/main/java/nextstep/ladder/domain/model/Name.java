package nextstep.ladder.domain.model;

public class Name {
  private static final int NAME_SIZE_LIMIT = 5;

  private String name;

  public Name(String name) {
    throwIfInvalid(name);

    this.name = name;
  }

  private void throwIfInvalid(String name) {
    if (name.length() > NAME_SIZE_LIMIT) {
      throw new IllegalArgumentException("6글자 넘는 이름은 생성할 수 없습니다.");
    }
  }

  public String getName() {
    return name;
  }
}
