package ladder;

import ladder.view.LadderGameInputView;

public class LadderGameApp {

  public static void main(String[] args) {
    LadderGameInputView ladderGameInputView = new LadderGameInputView();
    ladderGameInputView.inputLadderUsers();
    ladderGameInputView.inputLadderHeight();
  }
}
