package ladder.model.prize;

import ladder.error.InvalidPrizeFormatException;

import java.util.Objects;
import java.util.Optional;

public class Prize {
  private static final String ZERO_SYMBOL = "꽝";
  private static final String NUMBER_PATTERN = "^[0-9]+$";
  private static final String INVALID_PRIZE_FORMAT_EXCEPTION_MESSAGE = "잘못된 결과를 입력했습니다.";

  private final String prize;

  public Prize(String prize) {
    checkPrize(prize);
    this.prize = prize;
  }

  public String prize() {
    return prize;
  }

  private void checkPrize(String prize) {
    Optional.ofNullable(prize)
      .filter(value -> value.matches(NUMBER_PATTERN) || value.equals(ZERO_SYMBOL))
      .orElseThrow(() ->
        new InvalidPrizeFormatException(INVALID_PRIZE_FORMAT_EXCEPTION_MESSAGE)
      );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Prize prize1 = (Prize) o;
    return prize.equals(prize1.prize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prize);
  }

}
