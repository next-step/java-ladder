package nextstep.ladder;

import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.PersonCount;
import nextstep.ladder.io.InputView;
import nextstep.ladder.io.ResultView;

public final class LadderManager {

  public static void main(String[] args) {
    People people = new People(InputView.inputNames());
    PersonCount personCount = people.personCount();
    ResultView.printNewLine();

    LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
    ResultView.printNewLine();
  }
}
