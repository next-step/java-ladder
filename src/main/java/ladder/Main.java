package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
  public static void main(String[] args) {
    LadderGame game = LadderGame.of(InputView.participants(), InputView.maxLadderHeight());
    ResultView.displayResult(game.result());
  }
}
