package ladderGame.step4.controller;

import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.service.Match;
import ladderGame.step4.view.InputView;
import ladderGame.step4.view.ResultView;

public class LadderMainController {

  public static final String ALL_NAMES = "all";

  public static void findLadderInfo(final Players players,
      final Ladder ladder, final Prizes prizes) {

    ResultView.printUsersName(players.playersName());
    ResultView.printLadder(ladder);
    ResultView.printPrizes(prizes);

    String findName = InputView.inputFindNames();

    while (!isContinue(findName)) {

      ResultView.printResult(Match.getMatchResults(players, ladder, findName), prizes);

      findName = InputView.inputFindNames();
    }

    ResultView.printResult(Match.getMatchResults(players, ladder, findName), prizes);
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}