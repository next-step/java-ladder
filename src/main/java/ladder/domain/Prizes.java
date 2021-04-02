package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(String[] prizes) {
    this.prizes = Arrays.stream(prizes)
        .map(Prize::new)
        .collect(Collectors.toList());
  }

}
