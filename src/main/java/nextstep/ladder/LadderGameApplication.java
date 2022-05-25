package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

  public static void main(String[] args) {
    Players players = new Players(Players.create(InputView.playerNames()));
    Height height = new Height(InputView.ladderHeight());
    Ladder ladder = new Ladder(height.height(), players.count());
    ResultView.print(players);
    ResultView.print(ladder);
  }
}
