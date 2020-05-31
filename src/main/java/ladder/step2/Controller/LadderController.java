package ladder.step2.Controller;

import ladder.step2.domain.Ladder;
import ladder.step2.domain.Participants;
import ladder.step2.domain.strategy.LadderLineStrategyImpl;
import ladder.step2.view.*;

public class LadderController {
  private static final InputView inputView = InputView.getInstance();
  private static final ResultView resultView = ResultView.getInstance();

  public static void main(String[] args) {
    Participants participants = inputView.inputParticipants();
    int height = inputView.inputHeight();

    Ladder ladder = Ladder.of(
      participants.size(),
      height,
      LadderLineStrategyImpl.getInstance()
    );

    resultView.viewLadder(ladder, participants);
  }
}
