package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.domain.LadderMachine.createLadderGame;
import static ladder.domain.LadderMachine.playLadderGame;

public class LadderApplication {

  public static void main(String[] args) {
    Users users = InputView.inputUsers();
    LadderRewards ladderRewards = InputView.inputRewards(users.countOfUser());
    LadderHeight ladderHeight = InputView.inputHeight();

    LadderGame ladderGame = createLadderGame(users, ladderHeight.height());
    ResultView.showLadder(ladderGame, ladderRewards);

    LadderResult ladderResult = playLadderGame(ladderGame, ladderRewards);
    ResultView.showResult(ladderResult);
  }
}
