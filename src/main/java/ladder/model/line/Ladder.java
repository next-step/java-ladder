package ladder.model.line;

import ladder.model.Height;
import ladder.strategy.LadderPointsStrategy;

public class Ladder {

  private final Lines lines;

  private Ladder(Lines lines) {
    this.lines = lines;
  }

  public static Ladder makeLadder(Height height, int countOfMatch, LadderPointsStrategy strategy) {
    return new Ladder(Lines.makeLines(height, countOfMatch, strategy));
  }

  public Lines lines() {
    return lines;
  }

}
