package nextstep.laddergame.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.laddergame.domain.Prize;
import nextstep.laddergame.domain.Prizes;

public class PrizesFactory {

  private PrizesFactory() {
  }

  public static Prizes createPrizes(String[] results, int width) {
    List<Prize> prizes = Arrays.stream(results)
        .map(result -> new Prize(result))
        .collect(Collectors.toList());

    return new Prizes(prizes, width);
  }
}
