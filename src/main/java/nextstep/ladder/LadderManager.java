package nextstep.ladder;

import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.People;
import nextstep.ladder.io.InputView;

public final class LadderManager {

  public static void main(String[] args) {
    People people = new People(InputView.inputNames());
    LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
  }
}
