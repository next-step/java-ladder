package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes, int width) {
    if (prizes.size() != width) {
      throw new IllegalArgumentException("보상 갯수가 참여자 갯수와 맞지 않습니다.");
    }

    this.prizes = prizes;
  }

  public List<Prize> getPrizes() {
    return Collections.unmodifiableList(prizes);
  }

  public Prize getPrize(int location) {
    return prizes.get(location);
  }
}
