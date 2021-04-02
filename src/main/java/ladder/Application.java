package ladder;

import java.util.List;
import ladder.controller.LadderGameController;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    String[] names = inputView.inputNames();
    String[] prizes = inputView.inputPrizes();
    int height = inputView.inputHeight();

    LadderGameController ladderGameController
        = new LadderGameController(height, names, prizes);

    resultView.printLadder(ladderGameController.getLadderGame());

  }
}
