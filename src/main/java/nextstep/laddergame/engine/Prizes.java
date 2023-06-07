package nextstep.laddergame.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes, int width) {
    validatePrizes(width, prizes);

    this.prizes = prizes;
  }

  public Prizes(String[] results, int width) {
    List<Prize> prizes = Arrays.stream(results)
        .map(result -> new Prize(result))
        .collect(Collectors.toList());

    validatePrizes(width, prizes);

    this.prizes = prizes;
  }

  private void validatePrizes(int width, List<Prize> prizes) {
    if (prizes.size() != width) {
      throw new IllegalArgumentException("보상 갯수가 참여자 갯수와 맞지 않습니다.");
    }
  }

  public List<Prize> getPrizes() {
    return Collections.unmodifiableList(prizes);
  }

  public Prize getPrize(int location) {
    return prizes.get(location);
  }
}
