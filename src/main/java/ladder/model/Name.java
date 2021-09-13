package ladder.model;

public class Name {

  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;

  private final String value;

  public Name(String value) {
    validateNameLength(value);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  private void validateNameLength(String name) {
    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(
          "생성 가능한 이름의 길이는 " + MIN_NAME_LENGTH + " ~ " + MAX_NAME_LENGTH + " 글자 입니다"
      );
    }
  }
}
