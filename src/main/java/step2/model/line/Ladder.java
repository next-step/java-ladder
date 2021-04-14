package step2.model.line;

import step2.model.Height;
import step2.strategy.LadderPointsStrategy;

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
