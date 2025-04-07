package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class Main {
  public static void main(String[] args) {
    String playerNamesInput = InputView.readPlayerNames();
    Players players = Players.from(playerNamesInput);

    int height = InputView.readHeight();
    Ladder ladder = new Ladder(players, height);

    ResultView.printLadder(ladder);
  }
}
