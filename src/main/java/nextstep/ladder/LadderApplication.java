package nextstep.ladder;

import nextstep.ladder.domain.EndPoints;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Length;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    Players players = Players.of(InputView.getNames());
    EndPoints endPoints = EndPoints.of(InputView.getResults(), players.size());
    Ladder ladder = Ladder.of(new Length(players.size()), new Length(InputView.getHeight()));
    ResultView.printLadder(players, ladder, endPoints);

    GameResult gameResult = makeResult(players, endPoints, ladder);
    String resultName = InputView.getResultName();
    ResultView.printResult(gameResult, resultName);
  }

  private static GameResult makeResult(Players players, EndPoints endPoints, Ladder ladder) {
    GameResult gameResult = new GameResult();
    for (int i = 0; i < players.size(); i++) {
      gameResult.add(players.playerByColumn(i), endPoints.valueByColumn(ladder.move(i)));
    }
    return gameResult;
  }
}
