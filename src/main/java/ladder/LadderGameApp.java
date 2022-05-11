package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderGameInputView;
import ladder.view.LadderGameOutputView;

public class LadderGameApp {

  public static void main(String[] args) {
    LadderGameInputView ladderGameInputView = new LadderGameInputView();
    ladderGameInputView.inputLadderUsers();
    ladderGameInputView.inputLadderHeight();

    LadderGame ladderGame = LadderGame.of(ladderGameInputView.getLadderUserNames(),
        ladderGameInputView.getLadderHeight());

    LadderGameOutputView.printLadderGame(ladderGame);
  }
}
