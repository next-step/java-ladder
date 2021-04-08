package nextstep.ladder.domain;

import java.util.Objects;

public final class LadderHeight {

  private final int ladderHeight;

  public LadderHeight(int ladderHeight) {
    this.ladderHeight = ladderHeight;
  }

  public int toInt() {
    return 0;
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
