package ladder.step2.domain;

import ladder.step2.domain.strategy.LadderLineStrategy;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {
  private final List<LadderLine> ladder;

  private Ladder (List<LadderLine> ladder) {
    this.ladder = ladder;
  }

  public static Ladder of (int participants, int height, LadderLineStrategy strategy) {
    int width = participants - 1;
    List<LadderLine> ladder = IntStream.range(0, height)
                                       .mapToObj(h -> LadderLine.of(width, strategy))
                                       .collect(toList());
    return new Ladder(ladder);
  }
}
