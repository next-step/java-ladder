package ladder.domain;

import java.util.Objects;

public class LadderHeight {

  public static final String INVALID_LADDER_HEIGHT_INPUT = "올바르지 않은 사다리 높이를 입력하셨습니다. 입력한 높이: %s";
  private final int height;

  public LadderHeight(int height) {
    validate(height);
    this.height = height;
  }

  public int height() {
    return height;
  }

  private void validate(int input) {
    if (input <= 0) {
      throw new IllegalArgumentException(String.format(INVALID_LADDER_HEIGHT_INPUT, input));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LadderHeight that = (LadderHeight) o;
    return height == that.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height);
  }
}
