package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.People;
import nextstep.ladder.exception.LadderException;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.ResultView;

public final class LadderManager {

  public static void main(String[] args) {
    People people = getPeople();
    ResultView.printNewLine();

    LadderHeight ladderHeight = getLadderHeight();
    ResultView.printNewLine();

    final Ladder ladder = new Ladder(ladderHeight, people);
    ResultView.printLadder(ladder);
  }

  private static People getPeople() {
    try {
      return People.from(InputView.inputNames());
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getPeople();
    }
  }

  private static LadderHeight getLadderHeight() {
    try {
      return new LadderHeight(InputView.inputLadderHeight());
    } catch (LadderException e) {
      System.err.println(e.getMessage());
      return getLadderHeight();
    }
  }
}
