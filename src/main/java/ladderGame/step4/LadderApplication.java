package ladderGame.step4;

import java.util.List;
import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.validation.Validation;
import ladderGame.step4.view.InputView;
import ladderGame.step4.view.ResultView;

public class LadderApplication {

  public static final String ALL_NAMES = "all";

  public static void main(String[] args) {

    String playerNames = InputView.inputUserNames();
    Validation.validationNames(playerNames);

    String goods = InputView.inputGoods();
    Validation.validationNamesAndGoodsCount(playerNames, goods);

    int ladderHeight = InputView.inputLadderHeight();
    Validation.validationLimitHeight(ladderHeight);

    LadderMainController ladderMainController = new LadderMainController();

    Players players = ladderMainController.findPlayers(playerNames);
    ResultView.printUsersName(players.playersName());

    Ladder ladder = ladderMainController.findLadder(ladderHeight, players.playersName().size());
    ResultView.printLadder(ladder);

    Prizes prizes = ladderMainController.findPrizes(goods, players.playersName().size());
    ResultView.printPrizes(prizes);

    String findName = InputView.inputFindNames();

    List<MatchResult> ladderInfo = ladderMainController.findResult(ladder, players, findName);

    while (!isContinue(findName)) {

      ResultView.printResult(ladderInfo, prizes);

      findName = InputView.inputFindNames();
      ladderInfo = ladderMainController.findResult(ladder, players, findName);
    }

    ResultView.printResult(ladderInfo, prizes);
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}