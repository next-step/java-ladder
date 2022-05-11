package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderGameInputView;
import ladder.view.LadderGameOutputView;

public class LadderGameApp {

  public static void main(String[] args) {
    LadderGameInputView ladderGameInputView = new LadderGameInputView();

    LadderGame ladderGame = LadderGame.of(ladderGameInputView.getLadderUsers(),
        ladderGameInputView.getLadderHeight());

    LadderGameOutputView.printLadderGame(ladderGame);
  }
}
