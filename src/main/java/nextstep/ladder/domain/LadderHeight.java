package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.LadderHeightTooLowException;

public final class LadderHeight {

  public static final int MIN = 1;

  private final int ladderHeight;

  public LadderHeight(int ladderHeight) {
    validateHeight(ladderHeight);
    this.ladderHeight = ladderHeight;
  }

  private void validateHeight(int ladderHeight) {
    if (ladderHeight < MIN) {
      throw new LadderHeightTooLowException();
    }
  }

  public int toInt() {
    return ladderHeight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LadderHeight)) {
      return false;
    }
    LadderHeight that = (LadderHeight) o;
    return ladderHeight == that.ladderHeight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight);
  }
}
