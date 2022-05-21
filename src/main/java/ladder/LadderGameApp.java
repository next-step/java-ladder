package ladder;

import ladder.domain.GameResults;
import ladder.domain.GameUsers;
import ladder.domain.LadderGame;
import ladder.view.LadderGameInputView;
import ladder.view.LadderGameOutputView;

public class LadderGameApp {

  public static void main(String[] args) {
    LadderGameInputView ladderGameInputView = LadderGameInputView.getInstance();

    GameUsers gameUsers = GameUsers.from(ladderGameInputView.getLadderUsers());
    GameResults gameResults = GameResults.from(ladderGameInputView.getGameResults());
    int ladderHeight = ladderGameInputView.getLadderHeight();

    LadderGame ladderGame = LadderGame.of(gameUsers, gameResults, ladderHeight,
        gameUsers.getUserSize());

    LadderGameOutputView ladderGameOutputView = LadderGameOutputView.getInstance();
    ladderGameOutputView.printLadderGame(ladderGame);

    ladderGameOutputView.printRepeatGameResult(ladderGame);
  }
}
