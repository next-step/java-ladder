package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameApplication {
  private static final String ALL = "all";

  public static void main(String[] args) {
    Participants participants = new Participants(InputView.inputParticipants());
    Rewards rewards = new Rewards(InputView.inputLadderRewards(participants.size()));
    Height height = new Height(InputView.inputMaxLadderHeight());

    Ladder ladder = new Ladder(participants.size(), height);
    OutputView.printLadderStatus(participants, ladder, rewards);

    LadderGame game = new LadderGame(ladder, rewards);
    LadderGameResult result = game.play(participants);

    queryResults(result);
  }

  private static void queryResults(LadderGameResult result) {
    String name = InputView.inputNameofResult();
    while (!ALL.equals(name)) {
      OutputView.printResult(result.getResult(name));
      name = InputView.inputNameofResult();
    }
    OutputView.printAllResults(result);
  }
}
