package ladder.step2.controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.LadderHeight;
import ladder.step2.domain.Participants;
import ladder.step2.domain.strategy.LadderLineStrategyImpl;
import ladder.step2.view.*;

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
