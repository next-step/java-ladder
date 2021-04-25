package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    Players players = InputView.playerNames();

    int width = players.totalSize() - 1;
    int height = InputView.height();
    ResultView.print(players, Ladder.generate(height, width));
  }
}
