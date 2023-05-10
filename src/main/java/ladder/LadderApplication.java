package ladder;

import ladder.domain.*;
import ladder.view.ResultView;

import static ladder.domain.LadderMachine.createLadderGame;
import static ladder.domain.LadderMachine.playLadderGame;
import static ladder.view.InputView.*;

public class LadderApplication {

  public static void main(String[] args) {
    Users users = inputUsers();
    LadderRewards ladderRewards = inputRewards(users.countOfUser());
    LadderHeight ladderHeight = inputHeight();

    LadderGame ladderGame = createLadderGame(users, ladderHeight.height());
    ResultView.showLadder(ladderGame, ladderRewards);

    LadderResult ladderResult = playLadderGame(ladderGame, ladderRewards);
    ResultView.showResult(ladderResult);
  }
}
