package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    Users users = InputView.inputUsers();
    LadderRewards ladderRewards = InputView.inputRewards(users.countOfUser());
    LadderHeight ladderHeight = InputView.inputHeight();

    LadderGame ladderGame = new LadderGame(users, ladderHeight.height(), ladderRewards);
    ResultView.showLadder(ladderGame);

    LadderResult ladderResult = ladderGame.play();
    ResultView.showResult(ladderResult);
  }
}
