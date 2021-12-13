package controller;

import domain.LadderGame;
import domain.strategy.HorizontalLineDrawingStrategy;
import view.LadderOutputView;

public class LadderController {
  public void startGame(String names, int ladderHeight, HorizontalLineDrawingStrategy strategy) {
    LadderGame ladderGame = new LadderGame(names, ladderHeight, strategy);

    LadderOutputView.showNames(ladderGame.getPlayers());
    LadderOutputView.showLadder(ladderGame.getLadder());
  }
}
