package ladder;

import ladder.controller.LadderGameController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
  public static void main(String[] args) {
    LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView());
    ladderGameController.start();
  }
}
