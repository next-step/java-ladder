package ladderGame.step4;

import java.util.List;
import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.model.MatchResult;
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

    ResultView.printUsersName(ladderMainController.findPlayersName(playerNames));
    ResultView.printLadder(ladderMainController.findLadder(ladderHeight));

    Prizes prizes = ladderMainController.findPrizes(goods);
    ResultView.printPrizes(prizes);

    String findName = InputView.inputFindNames();

    List<MatchResult> ladderInfo = ladderMainController.findResult(findName);

    while (!isContinue(findName)) {

      ResultView.printResult(ladderInfo, prizes);

      findName = InputView.inputFindNames();
      ladderInfo = ladderMainController.findResult(findName);
    }

    ResultView.printResult(ladderInfo, prizes);
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}