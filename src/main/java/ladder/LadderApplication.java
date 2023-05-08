package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    Users users = InputView.inputUsers();
    LadderRewards ladderRewards = InputView.inputRewards(users.countOfUser());
    LadderHeight ladderHeight = InputView.inputHeight();

    LadderGame ladderGame = new LadderGame(users, ladderHeight.height());
    ResultView.showLadder(ladderGame, ladderRewards);

    LadderResult ladderResult = ladderGame.play(ladderRewards);
    ResultView.showResult(ladderResult);
  }
}
