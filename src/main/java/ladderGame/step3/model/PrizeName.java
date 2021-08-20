package ladderGame.step3.model;

import java.util.Objects;

public class PrizeName {

  private static final String MSG_ERROR_FAIL_PRIZE_EMPTY = "상품명을 입력해 주세요.";

  private static final int LIMIT_PRIZE_LENGTH = 5;

  public static final String MSG_ERROR_FAIL_PRIZE_LENGTH = "상품명은 최대 5글자까지 가능합니다.";

  private final String prizeName;

  public PrizeName(final String prizeName) {
    validation(prizeName);
    this.prizeName = prizeName;
  }

  private void validation(final String prizeName) {
    checkPrizeEmpty(prizeName);
    checkPrizeLength(prizeName);
  }

  private void checkPrizeEmpty(final String prizeName) {
    if (prizeName == null || prizeName.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_FAIL_PRIZE_EMPTY);
    }
  }

  private void checkPrizeLength(final String prizeName) {
    if (prizeName.length() > LIMIT_PRIZE_LENGTH) {
      throw new IllegalArgumentException(MSG_ERROR_FAIL_PRIZE_LENGTH);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final PrizeName prizeName1 = (PrizeName) o;
    return Objects.equals(prizeName, prizeName1.prizeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizeName);
  }
}
