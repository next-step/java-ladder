package nextstep.ladder.domain.entity;

public class Name {

  private static final String NAME_LENGTH_ERROR_MESSAGE = "5글자 이상의 이름을 입력할 수 없습니다.";
  private static final int NAME_MAX_LENGTH = 5;

  private final String value;

  public Name(String value) {
    validLength(value);
    this.value = value;
  }

  private void validLength(String value) {
    if (value.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
    }
  }

  public String tellName() {
    return this.value;
  }
}
