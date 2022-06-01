package nextstep.ladder;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

  public static final String RESULT_ALL_COMMAND = "all";

  public static void main(String[] args) {
    Players players = new Players(Players.create(InputView.playerNames()));
    Results results = new Results(Results.create(InputView.results()));
    Height height = new Height(InputView.ladderHeight());
    Lines lines = Lines.of(height.height(), players.count());
    ResultView.print(players, lines, results);

    String playerName = InputView.resultPlayer();
    if (RESULT_ALL_COMMAND.equals(playerName)) {
      ResultView.result(players.players(), lines, results);
      return;
    }
    ResultView.print(results.result(lines.move(players.point(playerName))));
  }
}
