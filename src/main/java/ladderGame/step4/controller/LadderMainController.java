package ladderGame.step4.controller;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.service.LadderService;

public class LadderMainController {

  private final LadderService service = new LadderService();

  public LadderMainController() {
  }

  public Ladder findLadder(final int ladderHeight, final int playerCount) {
    return service.createLadder(ladderHeight, playerCount);
  }

  public Prizes findPrizes(final String goods, final int playerCount) {
    return service.createPrizes(goods, playerCount);
  }

  public Players findPlayers(final String playerNames) {
    return service.createPlayers(playerNames);
  }

  public List<MatchResult> findResult(final Ladder ladder, final Players players,
      final String findName) {
    return service.getMatchResults(ladder, players, findName);
  }
}