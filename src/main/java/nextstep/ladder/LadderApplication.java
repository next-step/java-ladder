package nextstep.ladder;

import nextstep.ladder.domain.Length;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;

public class LadderApplication {

  public static void main(String[] args) {
    Players players = Players.of(InputView.getNames());
    Length height = new Length(InputView.getHeight());

    Ladder ladder = new Ladder(new Length(players.size()), height);
  }
}
