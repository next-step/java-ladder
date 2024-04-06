package ladder.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prize {
  private static final String FAILURE = "꽝";
  private static final Pattern inputPattern = Pattern.compile("^(?:[1-9]\\d*|" + FAILURE + ")$");

  private final String value;

  public Prize(final String text) {
    validate(text);
    this.value = text;
  }

  private void validate(final String text) {
    if (text == null) {
      throw new IllegalArgumentException("잘못된 경품 입력입니다.");
    }

    Matcher matcher = inputPattern.matcher(text);
    if (!matcher.find()) {
      throw new IllegalArgumentException("잘못된 경품 입력입니다.");
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
