package nextstep.ladder.domain;

public class Length {

  private static final int MIN_LENGTH = 1;

  private final int value;

  public Length(int value) {
    validate(value);
    this.value = value;
  }

  private static void validate(int value) {
    if (value < MIN_LENGTH) {
      throw new IllegalArgumentException(String.format("길이는 %d보다 작을 수 없습니다.", MIN_LENGTH));
    }
  }

  public int getValue() {
    return value;
  }
}
