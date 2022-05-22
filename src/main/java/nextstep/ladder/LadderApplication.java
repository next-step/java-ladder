package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Length;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    Players players = Players.of(InputView.getNames());
    Results results = Results.of(InputView.getResults(), players.size());
    Ladder ladder = Ladder.of(new Length(players.size()), new Length(InputView.getHeight()));
    ResultView.printLadder(players, ladder, results);
  }
}
