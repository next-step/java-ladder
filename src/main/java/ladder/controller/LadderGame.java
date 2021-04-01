package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.NameStore;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {

  public void run() {
    Players players = new Players(NameStore.createPlayers(InputView.inputPlayerName()));
    Ladder ladder = new Ladder(players, InputView.inputHeight());

    ResultView.showPlayers(players);
    ResultView.showLadder(ladder);
  }
}
