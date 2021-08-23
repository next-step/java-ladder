package ladderGame.step4.service;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.MatchResults;
import ladderGame.step4.model.Players;

public class Match {

  public static List<MatchResult> getMatchResults(final Players players, final Ladder ladder,
      final String findName) {
    return MatchResults.createMatchResult(ladder, players).searchPrizeWithCondition(findName);
  }
}