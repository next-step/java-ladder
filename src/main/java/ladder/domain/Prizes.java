package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(String[] prizes) {
    this.prizes = Arrays.stream(prizes)
        .map(Prize::new)
        .collect(Collectors.toList());
  }

  public Stream<Prize> getPrizes() {
    return prizes.stream();
  }

  public Prize find(Position position) {
    return prizes.get(position.getValue());
  }

  public int numberOfPrizes() {
    return prizes.size();
  }
}
