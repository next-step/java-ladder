package ladder.domain;

public class Prize {
  private static final String FAILURE = "꽝";
  private final String value;

  public Prize(final String text) {
    validate(text);
    this.value = text;
  }

  private void validate(final String text) {
    if (text == null || text.isEmpty()) {
      throw new IllegalArgumentException("잘못된 경품 입력입니다.(공백)");
    }

    try {
      if (Integer.parseInt(text) < 0) {
        throw new IllegalArgumentException("잘못된 경품 입력입니다.(0보다 작은 값)");
      }
    } catch (NumberFormatException e) {
      if (FAILURE.equals(text)) {
        return;
      }
      throw new IllegalArgumentException("유효하지 않은 입력입니다.(숫자가 아닌 값)");
    }
  }

  public String textValue() {
    return this.value;
  }
}
