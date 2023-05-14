package ladder;

import java.io.IOException;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
  public static void main(String[] args) throws IOException {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    List<String> playerName = inputView.getPlayerName();
    int ladderHeight = inputView.ladderHeight();

    LadderGame game = new LadderGame(playerName, ladderHeight);

    resultView.printPlayers(game.getPlayers());
    resultView.printLadders(game.getLadderLines());
    game.play();

    inputView.tearDown();
  }
}
