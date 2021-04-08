package ladder.controller;

import ladder.domain.LadderResult;
import ladder.domain.Ladder;
import ladder.domain.store.NameStore;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.domain.store.ResultStore;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {

  public void run() {
    Players players = new Players(NameStore.createPlayers(InputView.inputPlayerName()));
    Ladder ladder = new Ladder(players, InputView.inputHeight());

    Results results = new Results(ResultStore.createResult(InputView.inputResult(), players));
    ResultView.showPlayers(players);
    ResultView.showLadder(ladder, results);

    LadderResult ladderResult = new LadderResult(ladder, results);
    ladderResult.result(players);

    String resultName = InputView.inputResultOfPerson();
    while (!"all".equals(resultName)) {
      ResultView.showResultOfPerson(results, resultName);
      resultName = InputView.inputResultOfPerson();
    }
    ResultView.showResultAll(results);
  }
}
