package ladderGame.step4.service;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.MatchResults;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;

public class LadderService {

  public Players createPlayers(final String playerNames) {
    return Players.from(playerNames);
  }

  public Ladder createLadder(final int ladderHeight, final int playerCount) {
    return Ladder.of(ladderHeight, playerCount);
  }

  public Prizes createPrizes(final String goods, final int playerCount) {
    return Prizes.of(goods, playerCount);
  }

  public List<MatchResult> getMatchResults(final Ladder ladder, final Players players, final String findName) {
    return MatchResults.createMatchResult(ladder, players).searchPrizeWithCondition(findName);
  }
}