package nextstep.ladder.domain;

import java.util.List;

public class LadderPrize {
  private List<String> prizes;

  public LadderPrize(List<String> prizes) {
    this.prizes = prizes;
  }

  public List<String> getPrizes() {
    return prizes;
  }

  public String findPrize(int index){
    return prizes.get(index);
  }
}
