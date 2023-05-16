package ladder.domain.prize;

import java.util.List;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public List<Prize> getPrizes() {
    return prizes;
  }


  public Prize getPrize(int indexOfResult) {
    return prizes.get(indexOfResult);
  }
}
