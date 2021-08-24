package ladderGame.step4.controller;

import static ladderGame.step4.validation.Validation.validationLimitHeight;
import static ladderGame.step4.validation.Validation.validationNamesAndGoodsCount;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.service.LadderService;

public class LadderMainController {

  private final String playerNames;

  private final String goods;

  private final int ladderHeight;

  private final LadderService service = new LadderService();

  public LadderMainController(final String playerNames, final String goods,
      final int ladderHeight) {

    validationNamesAndGoodsCount(playerNames, goods);
    validationLimitHeight(ladderHeight);

    this.playerNames = playerNames;
    this.goods = goods;
    this.ladderHeight = ladderHeight;
  }

  public Ladder valueOfLadder() {
    return service.createLadder(ladderHeight);
  }

  public Prizes valueOfPrizes() {
    return service.createPrizes(goods);
  }

  public List<String> valueOfPlayersName() {
    return service.createPlayers(playerNames);
  }

  public List<MatchResult> valueOfResult(final String findName) {
    return service.getMatchResults(findName);
  }
}