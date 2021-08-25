package ladderGame.step4.controller;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.service.LadderService;

public class LadderMainController {

  private final LadderService service = new LadderService();

  public LadderMainController() {
  }

  public Ladder findLadder(final int ladderHeight) {
    return service.createLadder(ladderHeight);
  }

  public Prizes findPrizes(final String goods) {
    return service.createPrizes(goods);
  }

  public List<String> findPlayersName(final String playerNames) {
    return service.createPlayers(playerNames);
  }

  public List<MatchResult> findResult(final String findName) {
    return service.getMatchResults(findName);
  }
}