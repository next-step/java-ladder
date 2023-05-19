package ladder.domain.ladder.reword;


import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.Objects;

public class LadderGameReword {
  private final int rewordPrize;

  public LadderGameReword(int rewordPrize) {
    throwIfRewordPrizeIsNotPositive(rewordPrize);
    this.rewordPrize = rewordPrize;
  }

  private void throwIfRewordPrizeIsNotPositive(int rewordPrize) {
    if (rewordPrize < 0) {
      throw new LadderGameException(ExceptionCode.REWORD_MUST_POSITIVE_ZERO);
    }
  }

  public int getRewordPrize() {
    return rewordPrize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderGameReword that = (LadderGameReword) o;
    return rewordPrize == that.rewordPrize;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rewordPrize);
  }
}
