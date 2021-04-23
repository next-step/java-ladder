package ladder.model.prize;

import ladder.error.NotMatchedSizesException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
  private static final String NOT_MATCHED_SIZES_MESSAGE = "참가자와 결과의 수가 일치하지 않습니다.";
  private static final String SPLIT_DELIMITER = ",";

  private final List<Prize> prizes;

  private Prizes(List<Prize> prizes) {
    this.prizes = prizes;
  }

  public static Prizes makePrizes(String typedPrizes, int countOfPerson) {
    List<Prize> prizes = new ArrayList<>();
    String[] splitPrizes = typedPrizes.split(SPLIT_DELIMITER);

    if (splitPrizes.length != countOfPerson) {
      throw new NotMatchedSizesException(NOT_MATCHED_SIZES_MESSAGE);
    }

    for (String prize : splitPrizes) {
      prizes.add(new Prize(prize));
    }
    return new Prizes(Collections.unmodifiableList(prizes));
  }

  public List<Prize> specificPrizes() {
    return prizes;
  }
}
