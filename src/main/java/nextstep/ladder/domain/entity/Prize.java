package nextstep.ladder.domain.entity;

public class Prize {

  private static final String EMPTY_STRING_ERROR = "null 혹은 비어있는 값은 입력할 수 없습니다.";

  private final String value;

  public Prize(String value) {
    validString(value);
    this.value = value;
  }

  private void validString(String value) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STRING_ERROR);
    }
  }

  public String getRank() {
    return value;
  }
}
