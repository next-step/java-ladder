package ladder.step3.Controller;

import ladder.step3.domain.*;
import ladder.step3.domain.strategy.*;
import ladder.step3.view.*;

public class LadderController {
  private static final InputView INPUT_VIEW = InputView.getInstance();
  private static final ResultView RESULT_VIEW = ResultView.getInstance();

  public static void main(String[] args) {
    Participants participants = INPUT_VIEW.inputParticipants();
    LadderHeight ladderHeight = INPUT_VIEW.inputHeight();

    Ladder ladder = Ladder.of(
      participants,
      ladderHeight,
      LadderLineStrategyImpl.getInstance()
    );

    RESULT_VIEW.viewLadder(ladder, participants);
  }
}
