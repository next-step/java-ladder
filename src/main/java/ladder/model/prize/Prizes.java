package ladder.model.prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Prizes {
  private static final String SPLIT_DELIMITER = ",";

  private final List<Prize> prizes;

  private Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public List<Prize> specificPrizes() {
    return prizes;
  }

  public static Prizes makePrizes(String typedPrizes, int countOfPerson) {
    List<Prize> prizes = new ArrayList<>();
    String[] splitPrizes = typedPrizes.split(SPLIT_DELIMITER);

    if (splitPrizes.length != countOfPerson) {
      throw new RuntimeException();
    }

    for (String prize : splitPrizes) {
      prizes.add(new Prize(prize));
    }
    return new Prizes(Collections.unmodifiableList(prizes));
  }
}
