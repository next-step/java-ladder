package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.People;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.ResultView;

public final class LadderManager {

  public static void main(String[] args) {
    People people = new People(InputView.inputNames());
    ResultView.printNewLine();

    LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
    ResultView.printNewLine();

    final Ladder ladder = new Ladder(ladderHeight, people);
    ResultView.printLadder(ladder);
  }
}
