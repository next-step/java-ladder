package nextstep.laddergame.domain;

import java.util.Objects;
import nextstep.laddergame.util.StringUtils;

public class Prize {

  private final String prize;

  public Prize(String prize) {
    StringUtils.checkNullOrBlank(prize);
    if (prize.trim().length() > 5) {
      throw new IllegalArgumentException("보상은 최대 5글자 까지 입력할 수 있습니다.");
    }
    this.prize = prize.trim();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prize prize1 = (Prize) o;
    return Objects.equals(prize, prize1.prize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prize);
  }

  public String getPrize() {
    return prize;
  }
}
