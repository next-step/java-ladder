package nextstep.ladder;


import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.domain.RandomLadderBarStatusDecider;
import nextstep.ladder.presentation.InputView;
import nextstep.ladder.presentation.ResultView;

public class Main {
  private static final InputView inputView = new InputView();
  private static final ResultView resultView = new ResultView();

  public static void main(String[] args) {
    PlayerNames playerNames = inputView.getPlayerNames();
    int ladderLength = inputView.getLadderLength();

    Ladder ladder = LadderFactory.createLadder(ladderLength, playerNames.size(), new RandomLadderBarStatusDecider());

    resultView.printResult(playerNames, ladder);
  }
}
