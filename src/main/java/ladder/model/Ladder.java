package ladder.model;

import ladder.model.line.Lines;
import ladder.model.member.Players;
import ladder.model.prize.Prizes;
import ladder.model.result.InterimResults;
import ladder.model.result.LadderTotalResults;
import ladder.strategy.LadderPointsStrategy;

public class Ladder {

  private final Lines lines;

  private Ladder(Lines lines) {
    this.lines = lines;
  }

  public static Ladder makeLadder(Height height, int countOfMatch, LadderPointsStrategy strategy) {
    return new Ladder(Lines.makeLines(height, countOfMatch, strategy));
  }

  public LadderTotalResults calculateLadderResults(Players players, Prizes prizes) {
    InterimResults interimResults = lines.checkLinesResult(players.size());

    return interimResults.toLadderTotalResult(players, prizes);
  }

  public Lines lines() {
    return lines;
  }

}
