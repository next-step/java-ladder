package ladder;

import ladder.domain.Lines;
import ladder.domain.Players;
import ladder.util.LineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderStart {

  public static void main(String[] args) {
    Players players = InputView.inputPlayers();
    int height = InputView.inputHeight();

    Lines lines = LineGenerator.generate(height, players);

    ResultView.view(players, lines);
  }

}
