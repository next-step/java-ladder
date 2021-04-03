package ladder;

import ladder.domain.LadderGame;
import ladder.domain.PrizeResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    String[] names = inputView.inputNames();
    String[] prizes = inputView.inputPrizes();
    int height = inputView.inputHeight();

    LadderGame ladderGame = new LadderGame(height, names, prizes);
    resultView.printLadder(ladderGame);

    PrizeResult prizeResult = ladderGame.play();

    while (true) {
      String result = inputView.inputResult();
      if (result.equals("-1")) {
        break;
      }

      if (result.equals("all")) {
        resultView.printAllResult(prizeResult);
        continue;
      }

      resultView.printEachResult(prizeResult, result);
    }
  }
}
