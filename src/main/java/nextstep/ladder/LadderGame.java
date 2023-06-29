package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.presentation.InputView;
import nextstep.ladder.presentation.ResultView;

public class LadderGame {

  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();

  public void play() {
    PlayerNames playerNames = inputView.getPlayerNames();
    int ladderLength = inputView.getLadderLength();

    Ladder ladder = LadderFactory.createLadder(ladderLength, playerNames.size());

    resultView.printResult(playerNames, ladder);
  }
}
