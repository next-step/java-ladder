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
    LadderGameInputView ladderGameInputView = new LadderGameInputView();

    GameUsers gameUsers = GameUsers.from(ladderGameInputView.getLadderUsers());
    int ladderHeight = ladderGameInputView.getLadderHeight();
    GameResults gameResults = GameResults.from(ladderGameInputView.getGameResults());
    LadderConnectStrategy ladderConnectStrategy = new RandomLadderConnectStrategy(ladderHeight,
        gameUsers.getUserSize());

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, ladderHeight,
        ladderConnectStrategy);

    LadderGameOutputView.printLadderGame(ladderGame);
  }
}
