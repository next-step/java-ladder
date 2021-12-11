package controller;

import domain.LadderGame;
import domain.strategy.RandomHorizontalLineDrawingStrategy;
import view.LadderInputView;
import view.LadderOutputView;

public class LadderController {
  public void startGame() {
    String names = LadderInputView.inputNames();
    int ladderHeight = LadderInputView.inputLadderHeight();

    LadderGame ladderGame = new LadderGame(names, ladderHeight, new RandomHorizontalLineDrawingStrategy());

    LadderOutputView.showNames(ladderGame.getPlayers());
    LadderOutputView.showLadder(ladderGame.getLadder());
  }
}
