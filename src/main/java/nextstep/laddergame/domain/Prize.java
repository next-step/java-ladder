package nextstep.laddergame.domain;

import nextstep.laddergame.util.StringUtils;

public class Prize {

  private String prize;

  public Prize(String prize) {
    StringUtils.checkNullOrBlank(prize);
    if (prize.trim().length() > 5) {
      throw new IllegalArgumentException("보상은 최대 5글자 까지 입력할 수 있습니다.");
    }
    this.prize = prize.trim();
  }

  public String getPrize() {
    return prize;
  }
}
