package ladderGame.step3;

import ladderGame.step3.model.Ladder;
import ladderGame.step3.model.Players;
import ladderGame.step3.model.Prizes;
import ladderGame.step3.service.FindResult;
import ladderGame.step3.view.InputView;
import ladderGame.step3.view.ResultView;

public class LadderApplication {

  public static final String ALL_NAMES = "all";

  public static void main(String[] args) {

    String usersName = InputView.inputUserNames();
    String goods = InputView.inputGoods();
    int ladderHeight = InputView.inputLadderHeight();

    Players players = new Players(Players.of(usersName));
    Prizes prizes = new Prizes(Prizes.createPrizes(goods, players.count()));
    Ladder ladder = new Ladder(Ladder.of(ladderHeight, players.count()));

    ResultView.printUsersName(players.playersName());
    ResultView.printLadder(ladder);
    ResultView.printPrizes(prizes);

    String findName = InputView.inputFindNames();
    FindResult findResult = new FindResult(players, ladder, prizes);

    while(!isContinue(findName)){

      ResultView.printResult(findResult.matchPrizes(findName));
      findName = InputView.inputFindNames();
    }

    ResultView.printResult(findResult.matchPrizes(findName));
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}