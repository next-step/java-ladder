package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderHeight;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
  public static void main(String[] args) {
    String users = InputView.inputUsers();
    LadderHeight ladderHeight = InputView.inputHeight();

    LadderGame ladderGame = new LadderGame(users, ladderHeight.height());
    ResultView.showLadder(ladderGame);
  }
}
