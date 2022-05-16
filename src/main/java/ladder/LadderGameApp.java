package ladder;

import ladder.domain.GameResults;
import ladder.domain.GameUsers;
import ladder.domain.LadderGame;
import ladder.domain.strategy.LadderConnectStrategy;
import ladder.domain.strategy.RandomLadderConnectStrategy;
import ladder.view.LadderGameInputView;
import ladder.view.LadderGameOutputView;

public class LadderGameApp {

  public static void main(String[] args) {
    LadderGameInputView ladderGameInputView = LadderGameInputView.getInstance();

    GameUsers gameUsers = GameUsers.from(ladderGameInputView.getLadderUsers());
    GameResults gameResults = GameResults.from(ladderGameInputView.getGameResults());
    int ladderHeight = ladderGameInputView.getLadderHeight();
    LadderConnectStrategy ladderConnectStrategy = new RandomLadderConnectStrategy(ladderHeight,
        gameUsers.getUserSize());

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, ladderHeight,
        ladderConnectStrategy);

    LadderGameOutputView ladderGameOutputView = LadderGameOutputView.getInstance();
    LadderGameOutputView.printLadderGame(ladderGame);

    while (true) {
      System.out.println();
      LadderGameOutputView.printGameResult(ladderGameInputView.getResultUser(), ladderGame);
    }
  }
}
