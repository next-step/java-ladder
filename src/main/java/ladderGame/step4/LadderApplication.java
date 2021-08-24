package ladderGame.step4;

import java.util.List;
import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.view.InputView;
import ladderGame.step4.view.ResultView;

public class LadderApplication {

  public static final String ALL_NAMES = "all";

  public static void main(String[] args) {

    String playerNames = InputView.inputUserNames();
    String goods = InputView.inputGoods();
    int ladderHeight = InputView.inputLadderHeight();

    LadderMainController ladderMainController = new LadderMainController(playerNames, goods, ladderHeight);

    ResultView.printUsersName(ladderMainController.valueOfPlayersName());
    ResultView.printLadder(ladderMainController.valueOfLadder());

    Prizes prizes = ladderMainController.valueOfPrizes();
    ResultView.printPrizes(prizes);

    String findName = InputView.inputFindNames();

    List<MatchResult> ladderInfo = ladderMainController.valueOfResult(findName);

    while (!isContinue(findName)) {

      ResultView.printResult(ladderInfo, prizes);

      findName = InputView.inputFindNames();
      ladderInfo = ladderMainController.valueOfResult(findName);
    }

    ResultView.printResult(ladderInfo, prizes);
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}