package ladder.domain;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Prize prize = (Prize) o;
    return value.equals(prize.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Prize{" +
            "value='" + value + '\'' +
            '}';
  }
}
