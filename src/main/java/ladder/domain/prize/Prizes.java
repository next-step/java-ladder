package ladder.domain.prize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public Prizes(String... prizes) {
    this(Arrays.stream(prizes)
        .map(Prize::new)
        .collect(Collectors.toList()));
  }


  public List<Prize> getPrizes() {
    return prizes;
  }


  public Prize getPrize(int indexOfResult) {
    return prizes.get(indexOfResult);
  }
}
