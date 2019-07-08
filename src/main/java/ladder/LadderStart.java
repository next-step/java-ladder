package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.util.LadderGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderStart {

  public static void main(String[] args) {
    Players players = InputView.inputPlayers();
    int height = InputView.inputHeight();

    Ladder ladder = LadderGenerator.generate(height, players);

    ResultView.view(players, ladder);
  }

}
