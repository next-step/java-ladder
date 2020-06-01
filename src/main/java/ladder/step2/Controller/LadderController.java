package ladder.step2.Controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.Participants;
import ladder.step2.domain.strategy.LadderLineStrategyImpl;
import ladder.step2.view.*;

public class LadderController {
  private static final InputView INPUT_VIEW = InputView.getInstance();
  private static final ResultView RESULT_VIEW = ResultView.getInstance();

  public static void main(String[] args) {
    Participants participants = INPUT_VIEW.inputParticipants();
    int height = INPUT_VIEW.inputHeight();

    Ladder ladder = Ladder.of(
      participants.size(),
      height,
      LadderLineStrategyImpl.getInstance()
    );

    RESULT_VIEW.viewLadder(ladder, participants);
  }
}
