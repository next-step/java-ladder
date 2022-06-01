package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

  public static void main(String[] args) {
    Players players = new Players(Players.create(InputView.playerNames()));
    Results results = new Results(Results.create(InputView.results()));
    Height height = new Height(InputView.ladderHeight());
    Lines lines = Lines.of(height.height(), players.count());
    ResultView.print(players, lines, results);

    Result result = results.result(lines.move(players.point(InputView.resultPlayer())));
    ResultView.print(result);
  }
}
